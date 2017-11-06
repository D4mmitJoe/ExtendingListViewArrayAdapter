package com.example.joem.extendinglistviewarrayadapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by JoeM on 10/21/2017.
 */

public class EmailAdapter extends ArrayAdapter<Email>{ //have to specify type of ArrayAdapter, in this case 'email'

    //constructor that gets passed the resource(layout ID of the row) and list of objects
    public EmailAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Email> objects) {
        super(context, resource, objects);
    }
    //This is the adapter, a method that extends ArrayAdapter
    //we display layout here in 'getView' method
    //enables us to display by returning a view from the xml layout and we inflate it and change it into a view object
    //the view object is used to provide the ability to display it after we populate it upon changing the parameters inside it
    @NonNull
    @Override
    //'convertView' is a view passed-on by getView, providing you with a view from a view pool
    //View pool is a recycling (as the app is scrolled up and down, the views disappear that from the screen go into the view pool)
    //when we call getView it gives us a previous view from the pool so infinite views aren't created
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //gets email item at position that is sent in that you would like to display by creating a view for
        Email email = getItem(position);

        ViewHolder viewHolder;

        //convertView optimizes code
        if(convertView == null){ //if convertView is null we create a view

            //we put the layout we want to inflate into '.inflate()'
            //we can control what the layout looks like with the following
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.email_item, parent, false);

            //when we inflate a new convertView we create a new viewHolder and insert it into convertView
            viewHolder = new ViewHolder();

            //after we inflate convertView we update viewHolder via the following
            viewHolder.textViewSubject = (TextView) convertView.findViewById(R.id.textViewSubject);
            viewHolder.textViewSummary = (TextView) convertView.findViewById(R.id.textViewSummary);
            viewHolder.textViewEmail = (TextView) convertView.findViewById(R.id.textViewEmail);

            //store viewHolder in view via the following
            //sets tag of convertView to viewHolder
            convertView.setTag(viewHolder);
        }else{ //if not null we go and get viewHolder directly using the following
            //retrieve viewHolder from convertView via the following
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //get views (specifically the ones we just inflated) by the following
            //commented out bc not optimal cause calling 'findViewById' every time
            //implemented optimal code above ('viewHolder.textView...') and below ('viewHolder.textView...')
        /*TextView textViewSubject = (TextView) convertView.findViewById(R.id.textViewSubject);
        TextView textViewSummary = (TextView) convertView.findViewById(R.id.textViewSummary);
        TextView textViewEmail = (TextView) convertView.findViewById(R.id.textViewEmail);
        //populate data in view by the following
        textViewSubject.setText(email.subject);
        textViewSummary.setText(email.summary);
        textViewEmail.setText(email.sender);*/

        //saves time vs the above bc you only 'findViewById' once (managed by viewHolder) as opposed to every time
        viewHolder.textViewSubject.setText(email.subject);
        viewHolder.textViewSummary.setText(email.summary);
        viewHolder.textViewEmail.setText(email.sender);

        return convertView;
    }
    //viewHolder holds values found via 'findViewById' so you don't have to call it again and again
    private static class ViewHolder{
        TextView textViewSubject;
        TextView textViewSummary;
        TextView textViewEmail;
    }
}
