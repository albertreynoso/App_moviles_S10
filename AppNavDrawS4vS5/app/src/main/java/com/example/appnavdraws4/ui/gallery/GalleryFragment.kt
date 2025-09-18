package com.example.appnavdraws4.ui.gallery

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appnavdraws4.databinding.FragmentGalleryBinding
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.appnavdraws4.R

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)

        val btnToast = root.findViewById<Button>(R.id.btnNotificacionToast)
        val btnNotification = root.findViewById<Button>(R.id.btnSystem)

        btnToast.setOnClickListener{
            Toast.makeText(requireContext(), "!Notificación en pantalla!", Toast.LENGTH_SHORT).show()
        }
        btnNotification.setOnClickListener{
            val channelID = "canal_notificacion"

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                if(requireContext().checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 1001)
                    return@setOnClickListener
                }
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    channelID,
                    "Notification Simple",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                val manager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                manager.createNotificationChannel(channel)
            }

            val builder = NotificationCompat.Builder(requireContext(), channelID)
                .setSmallIcon(android.R.drawable.ic_input_add)
                .setContentTitle("Notificacion")
                .setContentText("Su pou esta enfermo")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            with(NotificationManagerCompat.from(requireContext())){
                notify(1, builder.build())
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}