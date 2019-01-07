package wiki.scene.aoptest

import android.view.View
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect

@Aspect
class AspectUtil {

    private var mLastView: View? = null

    @Around("execution(* android.view.View.OnClickListener.onClick(..))  && target(Object) && this(Object)")
    @Throws(Throwable::class)
    fun OnClickListener(joinPoint: ProceedingJoinPoint) {
        val objects = joinPoint.args
        val view = if (objects.isEmpty()) null else objects[0] as View
        val notDoubleClick = !NoDoubleClickUtils.isDoubleClick
        if (view !== mLastView || notDoubleClick) {
            joinPoint.proceed()
        }
        mLastView = view
    }
}
