package ru.skillbranch.devintensive.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView
import androidx.annotation.Dimension
import ru.skillbranch.devintensive.R

class CircleImageView @JvmOverloads constructor(
    context: Context,
   var  attrs: AttributeSet? = null,
    defStyleAttr: Int = 0

) : ImageView(context, attrs, defStyleAttr) {
    companion object {
        private const val DEFAULT_BORDER_COLOR = Color.BLACK
        private const val DEFAULT_BORDER_WIDTH = 2f
    }

    private var defColor = DEFAULT_BORDER_COLOR
    private var defBorder = DEFAULT_BORDER_WIDTH

    init {
       if (attrs != null) {
         val attributes = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
         setBorderWidth(10)

            attributes.recycle()
        }
    }

    override fun onDraw(canvas: Canvas?) {

        super.onDraw(canvas)
       val paintBorder: Paint = Paint()
        paintBorder.color = Color.BLACK
        val a = 5.0f
        canvas?.drawCircle(a,a,8f,paintBorder)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

    @Dimension
    fun getBorderWidth(): Int = R.styleable.CircleImageView_cv_border_width

    fun setBorderWidth(@Dimension dp: Int) {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
        attributes.getDimension(R.styleable.CircleImageView_cv_border_width, dp.toFloat())


    }
}