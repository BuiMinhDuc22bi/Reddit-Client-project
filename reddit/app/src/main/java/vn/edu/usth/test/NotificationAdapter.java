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
    private NotificationClickListener listener;

    public NotificationAdapter(List<Notification> notificationList, NotificationClickListener listener) {
        this.notificationList = notificationList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotificationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        return new NotificationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationHolder holder, int position) {
        Notification notification = notificationList.get(position);
        holder.notificationName.setText(notification.getNotificationName());
        holder.notificationImage.setImageResource(notification.getNotificationImage());
        holder.notificationText.setText(notification.getNotificationText());
        holder.bind(notification, listener);
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
            notificationName = itemView.findViewById(R.id.notification_name);
            notificationText = itemView.findViewById(R.id.notification_title);
            notificationImage = itemView.findViewById(R.id.notification_image);
        }

        public void bind(final Notification notification, final NotificationClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onNotificationClick(notification);
                }
            });
        }
    }
}