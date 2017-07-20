package com.example.lijunhao.testapplication;

/**
 * Created by win8 on 2017-07-18.
 */
        import android.content.Context;
        import android.graphics.BitmapFactory;
        import android.support.v4.view.ViewPropertyAnimatorListener;
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

    public CustomAdapter(Context c, ArrayList<Product> Products) {
        this.c = c;
        this.Products = Products;
    }
     static class ViewHolder {
        ImageView img;
        TextView nameTxt,propTxt,descTxt,Qty;
        Button btnCart,btnAdd,btnReduce;
//        ViewHolder(View v) {
//            TextView nameTxt= (TextView) v.findViewById(R.id.nameTxt);
//            TextView propTxt= (TextView) v.findViewById(R.id.price);
//            TextView descTxt= (TextView) v.findViewById(R.id.descTxt);
//            ImageView img=(ImageView) v.findViewById(R.id.img);
//            TextView Qty=(TextView) v.findViewById(R.id.Qty);
//          Button btnCart=(Button) v.findViewById(R.id.btnCart);
//             Button btnAdd=(Button) v.findViewById(R.id.btnAddQty);
//           Button btnReduce=(Button) v.findViewById(R.id.btnReduce);
    //}
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
        ViewHolder holder;
        if(convertView==null)
       {
           convertView= LayoutInflater.from(c).inflate(R.layout.list_item,parent,false);
          holder =new ViewHolder();
           holder.nameTxt=(TextView)convertView.findViewById(R.id.nameTxt);
           holder.propTxt=(TextView)convertView.findViewById(R.id.price);
           holder.descTxt=(TextView)convertView.findViewById(R.id.descTxt);
           holder.img=(ImageView)convertView.findViewById(R.id.img);
           holder.Qty=(TextView) convertView.findViewById(R.id.Qty);
           holder.btnCart=(Button) convertView.findViewById(R.id.btnCart);
           holder.btnAdd=(Button) convertView.findViewById(R.id.btnAddQty);
           holder.btnReduce=(Button) convertView.findViewById(R.id.btnReduce);
           convertView.setTag(holder);
       }else{
            holder=(ViewHolder) convertView.getTag();
        }
         //holder=convertView.getTag();
//           TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);
//           TextView propTxt= (TextView) convertView.findViewById(R.id.price);
//           TextView descTxt= (TextView) convertView.findViewById(R.id.descTxt);
//           ImageView img=(ImageView) convertView.findViewById(R.id.img);
//           final TextView Qty=(TextView) convertView.findViewById(R.id.Qty);
//           final Button btnCart=(Button) convertView.findViewById(R.id.btnCart);
//           final Button btnAdd=(Button) convertView.findViewById(R.id.btnAddQty);
//           final Button btnReduce=(Button) convertView.findViewById(R.id.btnReduce);
           final Product s= (Product) this.getItem(position);
           holder.nameTxt.setText(s.getpName());
           holder.propTxt.setText("Price: CAD$"+s.getpPrice());
           holder.descTxt.setText(s.getpDesc());
           Picasso.with(c).load(s.getpImage()).into(holder.img);
//           holder.btnCart.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View v) {
//
//                   holder.btnCart.setVisibility(v.GONE);
//                   if(Integer.parseInt(Qty.getText().toString())==0)
//                   Qty.setText("1");
//               }
//           });
//           btnAdd.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View v) {
//               if(Integer.parseInt(Qty.getText().toString())>1)
//                   Qty.setText(String.valueOf(Integer.parseInt(Qty.getText().toString())+1));
//               }
//           });
//           btnReduce.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View v) {
//
//                   Qty.setText(Integer.parseInt(Qty.getText().toString())-1);
//                   if(Integer.parseInt(Qty.getText().toString())==0){
//                       btnCart.setVisibility(v.VISIBLE);
//                   }
//               }
//           });
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