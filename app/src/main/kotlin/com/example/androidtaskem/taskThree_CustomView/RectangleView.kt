package com.example.androidtaskem.taskThree_CustomView

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View

class RectangleView(private val context: Context, private val attribute: AttributeSet) : View(context, attribute) {

    private val paint = Paint()
    private val rect = Rect(0, 0, 0, 0)
    private var isIncreased = true

    private var screenMaxWidth = 0
    private var screenMaxHeight = 0
    private var screenWidthStep = 0
    private var screenHeightStep = 0

    private val colors = arrayOf(
        Color.RED,
        Color.GREEN,
        Color.GRAY,
        Color.YELLOW,
        Color.BLUE,
        Color.BLACK,
        Color.MAGENTA,
        Color.CYAN,
        Color.DKGRAY
    )

    init {
        val displayMetrics = DisplayMetrics()
        (getContext() as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenMaxWidth = displayMetrics.widthPixels
        screenMaxHeight = displayMetrics.heightPixels
        screenWidthStep = (screenMaxWidth / 10) + 1
        screenHeightStep = (screenMaxHeight / 10) + 1
        rect.right = screenWidthStep
        rect.bottom = screenHeightStep
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val randomColor = colors.random()
        paint.color = randomColor
        canvas.drawRect(rect, paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                if (rect.right >= screenMaxWidth && rect.bottom >= screenMaxHeight) {
                    isIncreased = false
                }
                if (rect.right <= screenWidthStep && rect.bottom <= screenHeightStep) {
                    isIncreased = true
                }
                if (isIncreased) {
                    rect.right += screenWidthStep
                    rect.bottom += screenHeightStep
                } else {
                    rect.right -= screenWidthStep
                    rect.bottom -= screenHeightStep
                }
                requestLayout()
                invalidate()
            }
        }
        return super.onTouchEvent(event)
    }
}
