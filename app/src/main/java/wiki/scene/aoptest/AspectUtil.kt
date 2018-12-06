package wiki.scene.aoptest

import android.util.Log
import android.view.View
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect

@Aspect
class AspectUtil {
    private var canDoubleClick = false
    private var mLastView: View? = null

    @Around("execution(* android.view.View.OnClickListener.onClick(..))  && target(Object) && this(Object)")
    @Throws(Throwable::class)
    fun OnClickListener(joinPoint: ProceedingJoinPoint) {
        Log.e("xxxx", "OnClickListener---AOP")
        val objects = joinPoint.args
        val view = if (objects.size == 0) null else objects[0] as View
        val notDoubleClick = !NoDoubleClickUtils.isDoubleClick
        if (view !== mLastView || canDoubleClick || notDoubleClick) {
            Log.e("xxxx", "canDoubleClick---AOP")
            joinPoint.proceed()
            canDoubleClick = false
        }
        mLastView = view
    }
}
