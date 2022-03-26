package com.example.customviewprac

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import com.example.customviewprac.databinding.LayoutEdittextBinding

class CustomeEdittext @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    // defStyleAttr을 설정을 안해두었기 때문에 style을 설정안하겠다고 명시한 것임
    // 초기값 설정이 아닌 변경을 해주어야 하는 값에 대해서는 defStyleAttr을 선언하지 않아도 됨.
) : LinearLayout(
    context,
    attributeSet
){

    private lateinit var binding: LayoutEdittextBinding

    // activity에서 사용가능
    val editText : EditText = binding.edittext
    //val editText = findViewById<EditText>(R.id.edittext)

    val text: String
        get() = editText.text.toString()

    // binding 가능!
    private val button: ImageButton = binding.buttonClear

    init {
        // id를 xml에서 받아온 id로 바꾸면 독립적으로 변함
        this.id = id
        inflate(context, R.layout.layout_edittext, this)
        binding = LayoutEdittextBinding.bind(this)
        val typedArray = context.obtainStyledAttributes(
            attributeSet,
            R.styleable.CustomeEdittext
        )

        val initialText = typedArray.getString(R.styleable.CustomeEdittext_android_text)
        editText.setText(initialText)
        val initialHint = typedArray.getString(R.styleable.CustomeEdittext_android_hint)
        editText.hint = initialHint

        // 메모리 절약 재사용
        typedArray.recycle()

        // 재사용성
        button.setOnClickListener {
            editText.setText("")
        }
    }

}