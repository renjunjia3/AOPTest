package wiki.scene.aoptest

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class ItemAdapter(data: List<String>) : BaseQuickAdapter<String, BaseViewHolder>(R.layout.layout_item, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
        helper.setText(R.id.text, item)
    }

}