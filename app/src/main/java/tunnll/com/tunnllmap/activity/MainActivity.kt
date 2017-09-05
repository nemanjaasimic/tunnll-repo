package tunnll.com.tunnllmap.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import tunnll.com.tunnllmap.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ctx = applicationContext
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
        setContentView(R.layout.activity_main)

        val map: MapView = findViewById(R.id.map) as MapView
        map.setTileSource(TileSourceFactory.MAPNIK)

        map.setBuiltInZoomControls(true)
        map.setMultiTouchControls(true)

        val mapController: IMapController = map.controller
        mapController.setZoom(9)
        val startPoint = GeoPoint(48.2, 2.92)
        mapController.setCenter(startPoint)
    }

    override fun onResume() {
        super.onResume()
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))
    }
}
