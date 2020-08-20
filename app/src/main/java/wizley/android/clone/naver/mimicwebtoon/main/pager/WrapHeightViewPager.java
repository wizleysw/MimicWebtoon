package wizley.android.clone.naver.mimicwebtoon.main.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * Created by Shyish on 11/10/2015.
 * https://gist.github.com/aballano/2d62f2367d220a36fda2
 */
public class WrapHeightViewPager extends ViewPager {

    private int height = 0;
    private int decorHeight = 0;
    private int widthMeasuredSpec;

    public WrapHeightViewPager(Context context) {
        super(context);
    }

    public WrapHeightViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        widthMeasuredSpec = widthMeasureSpec;
        int mode = MeasureSpec.getMode(heightMeasureSpec);

        if (mode == MeasureSpec.UNSPECIFIED || mode == MeasureSpec.AT_MOST) {
            if (height == 0) {
                // measure vertical decors based on ViewPager implementation
                decorHeight = 0;
                for (int i = 0; i < getChildCount(); i++) {
                    View child = getChildAt(i);
                    LayoutParams lp = (LayoutParams) child.getLayoutParams();
                    if (lp != null) {
                        if (lp.isDecor) {
                            int vgrav = lp.gravity & Gravity.VERTICAL_GRAVITY_MASK;
                            boolean consumeVertical = vgrav == Gravity.TOP || vgrav == Gravity.BOTTOM;
                            if (consumeVertical) {
                                decorHeight += child.getMeasuredHeight();
                            }
                        } else {
                            height = Math.max(height, measureViewHeight(child));
                        }
                    }
                }
            }
            int totalHeight = height + decorHeight + getPaddingBottom() + getPaddingTop();
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(totalHeight, MeasureSpec.EXACTLY);
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private int measureViewHeight(View view) {
        view.measure(getChildMeasureSpec(widthMeasuredSpec,
                        getPaddingLeft() + getPaddingRight(),
                        view.getLayoutParams().width),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        return view.getMeasuredHeight();
    }
}