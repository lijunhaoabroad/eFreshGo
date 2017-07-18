package com.example.lijunhao.testapplication;

/**
 * Created by win8 on 2017-07-18.
 */
        import android.content.Context;
        import android.graphics.BitmapFactory;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;
        import com.example.lijunhao.testapplication.R;
        import com.example.lijunhao.testapplication.DataProduct;
        import java.util.ArrayList;
/**
 * Created by Oclemy on 6/21/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 * 1. where WE INFLATE OUR MODEL LAYOUT INTO VIEW ITEM
 * 2. THEN BIND DATA
 */
public class CustomAdapter extends BaseAdapter{
    Context c;
    ArrayList<DataProduct> products;
    public CustomAdapter(Context c, ArrayList<DataProduct> products) {
        this.c = c;
        this.products = products;
    }
    @Override
    public int getCount() {
        return products.size();
    }
    @Override
    public Object getItem(int position) {
        return products.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.list_item,parent,false);
        }
        TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);
        TextView propTxt= (TextView) convertView.findViewById(R.id.price);
        TextView descTxt= (TextView) convertView.findViewById(R.id.descTxt);
        ImageView img=(ImageView) convertView.findViewById(R.id.img);
        Button btnCart=(Button) convertView.findViewById(R.id.btnCart);
        final DataProduct s= (DataProduct) this.getItem(position);
        nameTxt.setText(s.getpName());
        propTxt.setText(s.getpPrice());
        descTxt.setText(s.getpDesc());
        img.setImageBitmap( BitmapFactory.decodeFile(s.getpImage()));

//        //ONITECLICK
//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(c,s.getpName(),Toast.LENGTH_SHORT).show();
//            }
//        });
        return convertView;
    }
}