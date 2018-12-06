package wiki.scene.aoptest

object NoDoubleClickUtils {
    private var lastClickTime: Long = 0
    private val SPACE_TIME = 1000

    val isDoubleClick: Boolean
        @Synchronized get() {
            val currentTime = System.currentTimeMillis()
            val isClick2: Boolean
            if (currentTime - lastClickTime > SPACE_TIME) {
                isClick2 = false
                lastClickTime = currentTime
            } else {
                isClick2 = true
            }
            return isClick2
        }
}