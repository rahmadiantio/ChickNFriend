//package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.adapter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model.HidanganEntity;
//import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.R;
//
//public class HidanganAdapter extends RecyclerView.Adapter<HidanganAdapter.HidanganHolder>{
//    private List<HidanganEntity> listHidangan = new ArrayList<>();
//
//    @NonNull
//    @Override
//    public HidanganHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.fragment_home, parent, false);
//        return new HidanganHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull HidanganHolder holder, int position) {
//        HidanganEntity hidanganSekarang = listHidangan.get(position);
//        holder.tvNama.setText(hidanganSekarang.getNama_hidangan());
//        holder.tvDesk.setText(hidanganSekarang.getDeskripsi_hidangan());
//        holder.tvKategori.setText(hidanganSekarang.getKategori_hidangan());
//        holder.tvHarga.setText(hidanganSekarang.getHarga_hidangan());
//    }
//
//    @Override
//    public int getItemCount() {
//        return listHidangan.size();
//    }
//
//    public void setListHidangan(List<HidanganEntity> listHidangan){
//        this.listHidangan = listHidangan;
//        notifyDataSetChanged();
//    }
//
//    class HidanganHolder extends RecyclerView.ViewHolder{
//        private TextView tvNama, tvDesk, tvKategori, tvFoto, tvHarga;
//
//        public HidanganHolder(@NonNull View itemView) {
//            super(itemView);
//            tvNama = itemView.findViewById(R.id.text_view_nama);
//            tvDesk = itemView.findViewById(R.id.text_view_deskripsi);
//            tvKategori = itemView.findViewById(R.id.text_view_kategori);
//            tvHarga = itemView.findViewById(R.id.text_view_harga);
//        }
//    }
//}
////public class RecyclerViewMakanan extends RecyclerView.Adapter<RecyclerViewMakanan.ViewHolder> {
////    private Context context;
////    private List<HidanganEntity> listHidanganEntity;
////    public RecyclerViewMakanan(Context context, List<HidanganEntity> listHidanganEntity){
////        this.context = context;
////        this.listHidanganEntity = listHidanganEntity;
////    }
////
////    @Override
////    public ViewHolder onCreateViewHolder (ViewGroup parent, int tipe){
////        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_hidangan
////        , parent, false);
////        ViewHolder viewHolder = new ViewHolder(view);
////        return viewHolder;
////    }
////
////    @Override
////    public void onBindViewHolder(@NonNull ViewHolder holder, final int posisi) {
////        final HidanganEntity hidanganEntity = listHidanganEntity.get(posisi);
////        holder.textViewNama.setText(hidanganEntity.getNama_makanan());
////        holder.textViewHarga.setText(hidanganEntity.getHarga_makanan());
////        String alamat = "";
////        alamat = MainActivity.URL+"upload/"+ hidanganEntity.getFoto_makanan();
////        Glide.with(context).load(alamat).into(holder.ivFotoHidangan);
////        holder.llallMenu.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(context, DetailMakananActivity.class);
////                intent.putExtra("nama_hidangan", listHidanganEntity.get(posisi).getNama_makanan());
////                intent.putExtra("deskripsi_hidangan", listHidanganEntity.get(posisi).getDeskripsi_makanan());
////                intent.putExtra("kateogori_hidangan", listHidanganEntity.get(posisi).getKategori_makanan());
////                intent.putExtra("harga_hidangan", listHidanganEntity.get(posisi).getHarga_makanan());
////                intent.putExtra("foto_hidangan", listHidanganEntity.get(posisi).getFoto_makanan());
////                context.startActivity(intent);
////            }
////        });
////    }
////
////    @Override
////    public int getItemCount() {
////        return listHidanganEntity.size();
////    }
////
////    public class ViewHolder extends RecyclerView.ViewHolder{
////        @BindView(R.id.tv_nama_hidangan)
////        TextView textViewNama;
////        @BindView(R.id.tv_harga_hidangan)
////        TextView textViewHarga;
////        @BindView(R.id.iv_foto_hidangan)
////        ImageView ivFotoHidangan;
////        @BindView(R.id.ll_all_menu)
////        LinearLayout llallMenu;
////
////        public ViewHolder(View view){
////            super(view);
////            ButterKnife.bind(this, view);
////        }
////    }
////}
