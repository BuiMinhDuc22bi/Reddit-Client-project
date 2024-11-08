package vn.edu.usth.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationHolder> {
    private List<Notification> notificationList;

    public NotificationAdapter(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public NotificationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the correct item layout for each notification
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        return new NotificationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationHolder holder, int position) {
        // Bind data to the views
        Notification notification = notificationList.get(position);
        holder.notificationName.setText(notification.getNotificationName());
        holder.notificationImage.setImageResource(notification.getNotificationImage());
        holder.notificationText.setText(notification.getNotificationText());
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    // ViewHolder for Notification
    public static class NotificationHolder extends RecyclerView.ViewHolder {
        TextView notificationName, notificationText;
        ImageView notificationImage;

        public NotificationHolder(@NonNull View itemView) {
            super(itemView);
            // Find views in the item layout
            notificationName = itemView.findViewById(R.id.notification_name);
            notificationText = itemView.findViewById(R.id.notification_title);
            notificationImage = itemView.findViewById(R.id.notification_image);
        }
    }
}
