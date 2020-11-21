package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model.Komentar;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.R;

public class RecyclerViewKomentar extends RecyclerView.Adapter<RecyclerViewKomentar.ViewHolder> {
    private Context context;
    private List<Komentar> komentarList;

    public RecyclerViewKomentar(Context context, List<Komentar> komentarList) {
        this.context = context;
        this.komentarList = komentarList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_komentar, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Komentar result = komentarList.get(position);
        holder.tvIsiKomentar.setText(result.getIsi_komentar());
    }

    @Override
    public int getItemCount() {
        return komentarList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_isi_komentar)
        TextView tvIsiKomentar;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

