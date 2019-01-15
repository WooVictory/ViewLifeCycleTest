package app.woovictory.viewlifecycletest

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.login_button_linear.view.*
import kotlinx.android.synthetic.main.login_button_relative.view.*

/**
 * Created by VictoryWoo
 */
class CustomButtonRelative(context: Context?) : RelativeLayout(context) {


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.v("RelativeCustomView 1009", "onMeasure")
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        Log.v("RelativeCustomView 1009", "onLayout")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.v("RelativeCustomView 1009", "onDraw")
    }

    constructor(context: Context, attrs: AttributeSet) : this(context) {
        initView()
        getAttrs(attrs)

    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : this(context) {
        initView()
        getAttrs(attrs, defStyle)
    }


    fun initView() {
        var inflaterService: String = Context.LAYOUT_INFLATER_SERVICE
        var inflater: LayoutInflater = context.getSystemService(inflaterService) as LayoutInflater
        var view: View = inflater.inflate(R.layout.login_button_relative, this, false)
        addView(view)
    }

    fun getAttrs(attrs: AttributeSet, defStyle: Int) {
        var typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.LoginButton, defStyle, 0)
        setTypeArray(typedArray)
    }

    fun getAttrs(attrs: AttributeSet) {
        var typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.LoginButton)
        setTypeArray(typedArray)
    }


    fun setTypeArray(typedArray: TypedArray) {
        var backgroundResourceId = typedArray.getResourceId(R.styleable.LoginButton_bg, R.color.kakao_color)
        bg_relative.setBackgroundResource(backgroundResourceId)

        var symbolResourceId = typedArray.getResourceId(R.styleable.LoginButton_symbol, R.drawable.kakao)
        symbol_relative.setImageResource(symbolResourceId)

        var textColor = typedArray.getColor(R.styleable.LoginButton_textColor, 0)
        text_relative.setTextColor(textColor)

        var textString = typedArray.getString(R.styleable.LoginButton_text)
        text_relative.text = textString

        typedArray.recycle()
    }


}