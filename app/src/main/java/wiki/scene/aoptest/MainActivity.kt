package wiki.scene.aoptest

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    var unbinder: Unbinder? = null
    var mAdapter: ItemAdapter? = null
    private var mList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        unbinder = ButterKnife.bind(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        for (i in 1..20) {
            mList.add("数据:$i")
        }
        mAdapter = ItemAdapter(mList)
        recyclerView.adapter = mAdapter
        mAdapter!!.onItemClickListener = OnItemClickListener { _, _, position ->
            run {
                //点击事件
                Log.e("提示", mList[position])
            }
        }
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
