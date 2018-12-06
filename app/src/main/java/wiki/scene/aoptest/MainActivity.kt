package wiki.scene.aoptest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder

class MainActivity : AppCompatActivity() {
    var unbinder: Unbinder? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        unbinder = ButterKnife.bind(this)
//        btn.setOnClickListener { Log.e("xx", "点击事件") }
    }

    @OnClick(R.id.btn)
    fun OnClickBtn(view: View) {
        Log.e("xx", "点击事件")
    }

    @OnClick(R.id.btn2)
    fun onClickBtn2() {
        Log.e("xx", "双击事件")
    }

    override fun onBackPressed() {
        //
        Log.e("xx", "onBackPressed")
    }

    override fun onDestroy() {
        super.onDestroy()
        unbinder!!.unbind()
    }
}
