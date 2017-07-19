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
        import com.example.lijunhao.testapplication.Product;
        import com.squareup.picasso.Picasso;

        import java.io.InputStream;
        import java.net.URL;
        import java.net.URLConnection;
        import java.util.ArrayList;
/**
 * Created by Oclemy on 6/21/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 * 1. where WE INFLATE OUR MODEL LAYOUT INTO VIEW ITEM
 * 2. THEN BIND DATA
 */
public class CustomAdapter extends BaseAdapter{
    Context c;
    ArrayList<Product> Products;
    public CustomAdapter(Context c, ArrayList<Product> Products) {
        this.c = c;
        this.Products = Products;
    }
    @Override
    public int getCount() {
        return Products.size();
    }
    @Override
    public Object getItem(int position) {
        return Products.get(position);
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
        final Product s= (Product) this.getItem(position);
        nameTxt.setText(s.getpName());
        propTxt.setText(s.getpPrice());
        descTxt.setText(s.getpDesc());
        Picasso.with(c).load(s.getpImage()).into(img);
//
//      try{
//            InputStream in = new java.net.URL(s.getpImage()).openStream();
//
//            img.setImageBitmap(BitmapFactory.decodeStream(in));
//        }catch (Exception e){
//            e.printStackTrace();
//       }
////
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