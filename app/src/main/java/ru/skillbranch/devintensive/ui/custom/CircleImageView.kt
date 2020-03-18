package ru.skillbranch.devintensive.ui.custom

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.os.CancellationSignal
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.Dimension
import androidx.annotation.Px
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.toRectF
import ru.skillbranch.devintensive.R
import ru.skillbranch.devintensive.extensions.dpToPx

class CircleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0

) : ImageView(context, attrs, defStyleAttr) {
    companion object {
        private const val DEFAULT_BORDER_COLOR = Color.WHITE
        private const val DEFAULT_BORDER_WIDTH = 2
    }

    @Px
    var borderWidth: Float = context.dpToPx(DEFAULT_BORDER_WIDTH)
    @ColorInt
    private var borderColor: Int = Color.WHITE

    private val maskPain = Paint(Paint.ANTI_ALIAS_FLAG)
    private val borderPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val viewRect = Rect()
    private lateinit var resultBm: Bitmap
    private lateinit var maskBm: Bitmap
    private lateinit var srcBm: Bitmap

    init {
        if (attrs != null) {
            val attributes = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
            borderWidth = attributes.getDimension(
                R.styleable.CircleImageView_cv_border_width,
                context.dpToPx(DEFAULT_BORDER_WIDTH)
            )
            borderColor = attributes.getColor(
                R.styleable.CircleImageView_cv_color,
                DEFAULT_BORDER_COLOR
            )

            attributes.recycle()
        }
        setup()
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (w == 0) return
        with(viewRect) {
            left = 0
            top = 0
            right = w
            bottom = h
        }
        prepareBitMaps(w, h)
    }

    override fun onDraw(canvas: Canvas?) {

        //   super.onDraw(canvas)
        canvas?.drawBitmap(resultBm,viewRect,viewRect,null)
      //  val half = (borderWidth/2).toInt()
        //viewRect.inset(half,half)
        canvas?.drawOval(viewRect.toRectF(),borderPaint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

    @Dimension
    fun getBorderWidth(): Int = borderWidth.toInt()

    fun setBorderWidth(@Dimension dp: Int){
        borderWidth=dp.toFloat()
    }
        fun setBorderColor(hex:String){
            borderColor=hex.toInt()
        }
   fun setBorderColor(@ColorRes colorId: Int){
       borderColor=colorId
   }
   fun getBorderColor():Int =borderColor



    private fun setup() {
        with(maskPain) {
            color = Color.WHITE
            style = Paint.Style.FILL
        }
        with(borderPaint){
            style=Paint.Style.STROKE
            strokeWidth =borderWidth
            color=borderColor
        }
    }

    private fun prepareBitMaps(w: Int, h: Int) {
        maskBm = Bitmap.createBitmap(w, h, Bitmap.Config.ALPHA_8)
        resultBm = maskBm.copy(Bitmap.Config.ARGB_8888,true)
        val maskCanvas = Canvas(maskBm)
        maskCanvas.drawOval(viewRect.toRectF(),maskPain)
        maskPain.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        srcBm=drawable.toBitmap(w,h,Bitmap.Config.ARGB_8888)
        val resultCanvas = Canvas(resultBm)
        resultCanvas.drawBitmap(maskBm,viewRect,viewRect,null)
        resultCanvas.drawBitmap(srcBm,viewRect,viewRect,maskPain)

    }

}