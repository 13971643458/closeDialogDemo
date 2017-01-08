package com.example.liuwenxiang.closedialogdemo;

/**
 * Created by liuwenxiang on 17/1/4.
 */

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by fuchenming on 16/11/24.
 */
public class PolicyDialog extends Dialog {


    public PolicyDialog(Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    public PolicyDialog(Context context) {
        super(context);
    }

    public static class Builder {
        private Context context;
        private String title;
        private String message;
        private String messageTitle;
        private String messageFooter;
        private String buttonText;
        private boolean cancelable;
        private ButtonCallBack buttonCallBack;

        public Builder(Context context) {
            this.context = context;
        }

        /**
         * 设置对话框相关信息
         *
         * @param title
         * @param messageTitle
         * @param message
         * @param buttonText
         * @return
         */
        public Builder setDialogInfo(String title, String messageTitle, String message,
                                     String messageFooter, String buttonText, boolean cancelable, ButtonCallBack buttonCallBack) {
            this.title = title;
            this.messageTitle = messageTitle;
            this.message = message;
            this.buttonText = buttonText;
            this.messageFooter = messageFooter;
            this.cancelable = cancelable;
            this.buttonCallBack = buttonCallBack;
            return this;
        }

        public PolicyDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final PolicyDialog dialog = new PolicyDialog(context,R.style.Dialog);
            View layout = inflater.inflate(R.layout.policy_dialog, null);
            dialog.setContentView(layout);



            if (title == null || messageTitle == null || messageFooter == null || message == null) {
                return null;
            }
            // set the dialog text info
            ((TextView) layout.findViewById(R.id.title)).setText(title);
            ((TextView) layout.findViewById(R.id.message_title)).setText(messageTitle);
            ((TextView) layout.findViewById(R.id.message)).setText("\t\t"+message);

            ((TextView) layout.findViewById(R.id.message_footer)).setText(messageFooter);



            // set the button
            ((Button) layout.findViewById(R.id.submit)).setText(buttonText);
            layout.findViewById(R.id.btn_pop_close).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (buttonCallBack != null) {
                        buttonCallBack.closeClick();
                        dialog.dismiss();
                    }

                }
            });
            layout.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            if (buttonCallBack != null) {
                                buttonCallBack.buttonClick();
                                dialog.dismiss();
                            }
                        }
                    });
            // set the dialog cancel click
            layout.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (buttonCallBack != null) {
                        buttonCallBack.cancelClick();
                        dialog.dismiss();
                    }
                }
            });
            dialog.setContentView(layout);
            dialog.setCancelable(cancelable);

            Window dialogWindow = dialog.getWindow();
            dialogWindow.setGravity(Gravity.CENTER );

            return dialog;
        }
    }

    public interface ButtonCallBack {
        void buttonClick();

        void cancelClick();

        void closeClick();
    }
}

