package com.example.singbike.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singbike.Models.Ride;
import com.example.singbike.R;

import java.util.ArrayList;

public class RideHistoryRecyclerViewAdapter extends RecyclerView.Adapter<RideHistoryRecyclerViewAdapter.ViewHolder> {

    /* implement onClick Listener */
    public interface RideHistoryItemOnClickListener {
        void rideItemOnClickListener (Ride ride);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView rideDistance, rideTime;

        public ViewHolder (View v) {
            super(v);
            this.rideDistance = v.findViewById (R.id.rideDistance_RideHistory);
            this.rideTime = v.findViewById (R.id.rideTime_RideHistory);
        }

        public void bind (final Ride ride, final RideHistoryItemOnClickListener listener) {
            this.rideTime.setText (ride.getRideTime());
            this.rideDistance.setText (ride.getRideDistance());

            itemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listener.rideItemOnClickListener(ride);
                        }
                    }
            );
        }

    }

    private final ArrayList<Ride> rides;
    private final RideHistoryItemOnClickListener listener;

    public RideHistoryRecyclerViewAdapter (ArrayList<Ride> rides, RideHistoryItemOnClickListener listener) {
        this.rides = rides;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, final int position) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate (R.layout.ride_history_item, viewGroup, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder (@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.bind (this.rides.get(position), this.listener);
    }

    @Override
    public int getItemCount () { return this.rides.size(); }

}
