package org.rome.easycity;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class EasyCityMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_city_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Προσδιορισμός εκδηλώσεων από backend
        float zoomLevel = (float) 13.0;
        LatLng myLocation = new LatLng(37.98, 23.72);
        LatLng museum = new LatLng(37.989, 23.732);
        LatLng acropol = new LatLng(37.971, 23.725);


        mMap.addMarker(new MarkerOptions().position(myLocation).title("Είμαι εδώ"));
        mMap.addMarker(new MarkerOptions().position(museum).title("ΕΘΝΙΚΟ ΑΡΧΑΙΟΛΟΓΙΚΟ ΜΟΥΣΕΙΟ").snippet("Ομιλία του καθηγητή Ερενίδη  12 Ιουνίου στις 13:30"));
        mMap.addMarker(new MarkerOptions().position(acropol).title("ΑΚΡΟΠΟΛΙΣ ΑΘΗΝΩΝ").snippet("Ξενάγηση με τον καθηγητή κ. Χαραλαμπόπουλο 20 Μαΐου στις 11:00 πμ "));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation,zoomLevel));
    }
}
