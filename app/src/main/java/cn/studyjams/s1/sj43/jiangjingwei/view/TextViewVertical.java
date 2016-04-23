package cn.studyjams.s1.sj43.jiangjingwei.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by David on 2016/4/23.
 */
public class TextViewVertical extends TextView {




        public TextViewVertical(Context context, AttributeSet attrs) {
            super(context, attrs);
            // TODO Auto-generated constructor stub
        }

        public TextViewVertical(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void setText(CharSequence text, BufferType type) {
            // TODO Auto-generated method stub
            if ("".equals(text) || text == null || text.length() == 0) {
                return;
            }
            int m = text.length();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < m; i++) {
                CharSequence index = text.toString().subSequence(i, i + 1);
                sb.append(index + "\n");
            }
            super.setText(sb, type);
        }

    }

