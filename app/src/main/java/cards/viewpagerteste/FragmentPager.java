package cards.viewpagerteste;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cards.viewpagerteste.Adapter.AdapterList;

public class FragmentPager extends Fragment {

    private static final String ARG_KEY_LIST = "FragmentPager.list";

    public static FragmentPager newInstance(List<String> list) {
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_KEY_LIST, new ArrayList<>(list));

        FragmentPager fragment = new FragmentPager();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(ARG_KEY_LIST))
        {
            List<String> listItens = arguments.getStringArrayList(ARG_KEY_LIST);
            // Inflate the layout for this fragment
            RecyclerView rvItens = (RecyclerView) view.findViewById(R.id.rv_itens);
            rvItens.setHasFixedSize(true);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), listItens.size(), GridLayoutManager.VERTICAL,false);
            rvItens.setLayoutManager(gridLayoutManager);

            AdapterList adapterList = new AdapterList(listItens);
            rvItens.setAdapter(adapterList);
        }

        return view;
    }
}
