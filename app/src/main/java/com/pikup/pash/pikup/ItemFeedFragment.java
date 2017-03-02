package com.pikup.pash.pikup;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemFeedFragment extends Fragment {
	Context context;
	View view;
	LinearLayoutManager llm;
	RecyclerAdapter reAdapter;
	RecyclerView reView;
	//MovieClicker m;
	//Button claimAll;


	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		this.context = context;
		//if (context instanceof MovieActivity)
		//	m = (MovieClicker) context;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		if (view != null)
			return view;
		view = inflater.inflate(R.layout.fragment_item_feed, container, false);
		reView = (RecyclerView) view.findViewById(R.id.recycc);
		llm = new LinearLayoutManager(context);
		reView.setLayoutManager(llm);
		reAdapter = new RecyclerAdapter();
		reView.setAdapter(reAdapter);
		return view;
	}



	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onDestroyView() {
		if (view.getParent() != null)
			((ViewGroup) view.getParent()).removeView(view);
		super.onDestroyView();
	}

	class RecyclerAdapter extends RecyclerView.Adapter<Holder> {

		boolean allCheckd = false;
		//View.OnClickListener itemClicker
		//View.OnLongClickListener itemLongClicker

		RecyclerAdapter() {
		}

		@Override
		public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
			View v = LayoutInflater.from(parent.getContext())
					.inflate(R.layout.feed_item, parent, false);
			return new Holder(v);
		}

		@Override
		public void onBindViewHolder(Holder holder, int position) {
			holder.img.setImageResource(R.drawable.place);
			holder.title.setText("PlaceHolder");
			holder.checkBox.setChecked(false);
			holder.card.setTag(position);
			holder.card.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					startActivity(new Intent(context, ItemDetailActivity.class));
					// int k = (int) v.getTag();
					// Get item from list of items
					// Pass to Item Detail Fragment .new Instance(item)

				}
			});
		}

		@Override
		public int getItemCount() {
			return 3;
		}

	}

	public static class Holder extends RecyclerView.ViewHolder {
		ImageView img;
		TextView title;
		CheckBox checkBox;
		CardView card;

		public Holder( View itemView) {
			super(itemView);
			card = (CardView) itemView.findViewById(R.id.card);
			img = (ImageView) itemView.findViewById(R.id.item_img);
			title = (TextView) itemView.findViewById(R.id.item_title);
			checkBox = (CheckBox) itemView.findViewById(R.id.item_check);
		}


	}
}
