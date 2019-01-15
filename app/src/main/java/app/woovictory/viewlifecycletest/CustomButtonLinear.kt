package app.woovictory.viewlifecycletest

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.login_button_linear.view.*

/**
 * Created by VictoryWoo
 */
class CustomButtonLinear(context: Context) : LinearLayout(context) {


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.v("LinearCustomView 1009", "onMeasure")
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        Log.v("LinearCustomView 1009", "onLayout")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.v("LinearCustomView 1009", "onDraw")
    }


    constructor(context: Context, attrs: AttributeSet) : this(context) {
        initView()
        getAttrs(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : this(context, attrs) {
        initView()
        getAttrs(attrs, defStyle)

    }

    private fun initView() {
        var inflaterService: String = Context.LAYOUT_INFLATER_SERVICE
        var inflater: LayoutInflater = context.getSystemService(inflaterService) as LayoutInflater
        var view = inflater.inflate(R.layout.login_button_linear, this, false)
        addView(view)
    }

    private fun getAttrs(attrs: AttributeSet, defStyle: Int) {
        var typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.LoginButton, defStyle, 0)
        //setTypeArray(typedArray)
        setting(attrs)
    }

    private fun getAttrs(attrs: AttributeSet) {
        var typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.LoginButton)
        //setTypeArray(typedArray)
        setting(attrs)
    }

    fun setting(attrs: AttributeSet) {
        context.theme.obtainStyledAttributes(attrs, R.styleable.LoginButton, 0, 0)
            .apply {

                try {
                    var backgroundResourceId = getResourceId(R.styleable.LoginButton_bg, R.color.naver_color)
                    bgLinear.setBackgroundResource(backgroundResourceId)

                    var symbolResourceId = getResourceId(R.styleable.LoginButton_symbol, R.drawable.naver)
                    symbolLinear.setImageResource(symbolResourceId)

                    var textColor = getColor(R.styleable.LoginButton_textColor, 0)
                    textLinear.setTextColor(textColor)

                    var textString = getString(R.styleable.LoginButton_text)
                    textLinear.text = textString
                } finally {
                    recycle()
                }
            }

    }

    /*   private fun setTypeArray(typedArray: TypedArray) {
           var backgroundResourceId = typedArray.getResourceId(R.styleable.LoginButton_bg, R.color.naver_color)
           bgLinear.setBackgroundResource(backgroundResourceId)

           var symbolResourceId = typedArray.getResourceId(R.styleable.LoginButton_symbol, R.drawable.naver)
           symbolLinear.setImageResource(symbolResourceId)

           var textColor = typedArray.getColor(R.styleable.LoginButton_textColor, 0)
           textLinear.setTextColor(textColor)

           var textString = typedArray.getString(R.styleable.LoginButton_text)
           textLinear.text = textString

           typedArray.recycle()
       }*/


}