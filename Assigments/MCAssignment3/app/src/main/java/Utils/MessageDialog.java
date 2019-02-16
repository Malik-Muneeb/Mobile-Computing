package Utils;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;



public class MessageDialog {

    private Context context;

    public MessageDialog(Context context) {
        this.context = context;
    }

    public boolean showAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Error!");
        builder.setMessage("No Network Connection!");
        builder.create();
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
                ((Activity) context).finish();
            }
        });

        builder.show();
        return false;
    }
}
