package cards.viewpagerteste.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

import cards.viewpagerteste.R;

/**
 * Created by galdino on 27/04/2017.
 */

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder>
{
    // Variáveis
    private List<String> listTexto;
    // Listenner
    private AdapterView.OnItemClickListener mOnItemClickListener;

    public AdapterList(List<String> listTexto) {
        this.listTexto = listTexto;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv1;
        TextView tv2;
        public ViewHolder(final View itemView)
        {
            super(itemView);

            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int posicao = getAdapterPosition();
//                    mOnItemClickListener.onItemClick(v,posicao);
//                }
//            });
        }
    }
    @Override
    public AdapterList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapter_list,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterList.ViewHolder holder, int position)
    {
        holder.tv1.setText(Integer.toString(position));
        holder.tv2.setText(listTexto.get(position));
    }

    @Override
    public int getItemCount()
    {
        return listTexto.size();
    }

    public void setmOnItemClickListener(AdapterView.OnItemClickListener mOnItemClickListener)
    {
        this.mOnItemClickListener = mOnItemClickListener;
    }
}
