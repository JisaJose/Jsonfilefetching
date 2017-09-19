package com.example.jsonfilefetching;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jisajose on 2017-09-13.
 */

public class ContactAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public ContactAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }


    public void add(Contacts object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();

    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


View row;
    row=convertView;
        ContactHolder contactHolder;
        if(row==null){
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = layoutInflater.inflate(R.layout.rowlayout,parent,false);
            contactHolder  =new ContactHolder();
            contactHolder.tx_name = (TextView) row.findViewById(R.id.name);
            contactHolder.tx_id = (TextView) row.findViewById(R.id.cu_id);
            contactHolder.tx_email_id = (TextView) row.findViewById(R.id.emai_id);
            contactHolder.tx_created_at= (TextView) row.findViewById(R.id.created_at);
            contactHolder.tx_updated_at = (TextView) row.findViewById(R.id.updated_at);
            contactHolder.tx_user_id = (TextView) row.findViewById(R.id.uder_id);
            contactHolder.tx_token = (TextView) row.findViewById(R.id.token);
            row.setTag(contactHolder);
        }
        else {
             contactHolder = (ContactHolder)row.getTag();
        }
        Contacts contacts =(Contacts ) this. getItem(position);
contactHolder.tx_name.setText(contacts.getName());
        contactHolder.tx_token.setText(contacts.getToken());
        contactHolder.tx_user_id.setText(contacts.getUser_id());
        contactHolder.tx_email_id.setText(contacts.getEmail_id());
        contactHolder.tx_created_at.setText(contacts.getCreated_at());
        contactHolder.tx_updated_at.setText(contacts.getUpdated_at());
        contactHolder.tx_id.setText(contacts.getId());

        return row;
    }

    static class ContactHolder {
        TextView tx_name, tx_email_id, tx_created_at, tx_updated_at, tx_token, tx_user_id, tx_id;

    }
}
