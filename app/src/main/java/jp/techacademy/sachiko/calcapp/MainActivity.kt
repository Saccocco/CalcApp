package jp.techacademy.sachiko.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.support.design.widget.Snackbar
import android.util.Log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonMultiply.setOnClickListener(this)
        buttonDivide.setOnClickListener(this)

    }

    override fun onClick(v: View){
        //入力チェック
        //エディットテキストが空だったら，SnackBarでユーザに通知
        var result = 0.0

        if(editText1.text.toString() == "" || editText2.text.toString() == "" ){
            Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action"){
                    Log.d("UI_PARTS", "Snackbarをタップした")
                }.show()
        }else{
            val intent = Intent(this, ResultActivity::class.java)
            //editTextからString型の文字列を取得して，数値に変換する。
            val num1 = editText1.text.toString().toDouble()
            val num2 = editText2.text.toString().toDouble()
            if(v.id == R.id.buttonPlus){
                result = num1 + num2
            }else if(v.id == R.id.buttonMinus) {
                result = num1 - num2
            }
            else if(v.id == R.id.buttonMultiply) {
                result = num1 * num2
            }
            else if(v.id == R.id.buttonDivide) {
                result = num1 / num2
            }

        }
        intent.putExtra("result", result)
        startActivity(intent)
    }

}
