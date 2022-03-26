package com.example.customviewprac

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class Button @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyleAttr: Int = R.attr.customButtonStyle
): AppCompatButton(context, attributeSet, defStyleAttr) {

    init {
        // 커스텀버튼이 메모리를 계속 잡고 있음
        // 버튼이 많이 만들어질 수록 그대로 메모리도 계속 사용됨
        val typedArray = context.obtainStyledAttributes(
            attributeSet,
            R.styleable.Button
        )

        // 메모리 절약 재사용!
        typedArray.recycle()
    }
}