package com.example.lijunhao.testapplication;

/**
 * Created by win8 on 2017-07-18.
 */
        import android.content.Context;
        import android.graphics.BitmapFactory;
        import android.support.v4.view.ViewPropertyAnimatorListener;
        import android.support.v7.widget.CardView;
        import android.support.v7.widget.RecyclerView;
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
    int number=0;
    LayoutInflater inflater;

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
        if(inflater==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
       {
           convertView= LayoutInflater.from(c).inflate(R.layout.list_item,parent,false);
       }
           TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);
           TextView propTxt= (TextView) convertView.findViewById(R.id.price);
           TextView descTxt= (TextView) convertView.findViewById(R.id.descTxt);
           ImageView img=(ImageView) convertView.findViewById(R.id.img);
           final TextView Qty=(TextView) convertView.findViewById(R.id.Qty);
           final Button btnCart=(Button) convertView.findViewById(R.id.btnCart);
           final Button btnAdd=(Button) convertView.findViewById(R.id.btnAddQty);
           final Button btnReduce=(Button) convertView.findViewById(R.id.btnReduce);
           final Product s= (Product) this.getItem(position);
           nameTxt.setText(s.getpName());
           propTxt.setText("Price: CAD$"+s.getpPrice());
           descTxt.setText(s.getpDesc());
           Picasso.with(c).load(s.getpImage()).into(img);
         btnCart.setOnClickListener(new CardView.OnClickListener() {
             @Override
             public void onClick(View v) {
                 btnCart.setVisibility(v.GONE);
                 number=1;
                 Qty.setText(String.valueOf(number));
             }
         });
           btnAdd.setOnClickListener(new CardView.OnClickListener() {
               @Override
               public void onClick(View v) {
                   v.setTag(Qty.getText().toString());
               if(v.getTag()!=null)
                   number=Integer.parseInt(v.getTag().toString())+1;
                   Qty.setText(String.valueOf(number));
               }
           });
           btnReduce.setOnClickListener(new CardView.OnClickListener() {
               @Override
               public void onClick(View v) {
                   v.setTag(Qty.getText().toString());
                   if(v.getTag()!=null){
                       number=Integer.parseInt(v.getTag().toString())-1;
                   Qty.setText(String.valueOf(number));
               }
                   if(number==0){
                       btnCart.setVisibility(v.VISIBLE);
                   }
               }
           });



        return convertView;
    }
}