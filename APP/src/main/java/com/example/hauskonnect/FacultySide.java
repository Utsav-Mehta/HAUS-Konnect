package com.example.hauskonnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

/**
 * The type Faculty side.
 */
public class FacultySide extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    /**
     * The Drawer layout 1.
     */
    DrawerLayout drawerLayout1;
    /**
     * The Navigation view 1.
     */
    NavigationView navigationView1;
    /**
     * The Menu.
     */
    ImageView menu;
    /**
     * The Content view 1.
     */
    LinearLayout contentView1;
    /**
     * The Fauth.
     */
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_side);

        drawerLayout1 = findViewById(R.id.fac_drawer_layout);
        navigationView1 = findViewById(R.id.fac_nav_view);
        menu= findViewById(R.id.fac_menu_icon);
        contentView1 = findViewById(R.id.content1);
        fauth=FirebaseAuth.getInstance();
        navigationDrawer();
    }

    private void navigationDrawer() {
        navigationView1.bringToFront();
        navigationView1.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
        navigationView1.setCheckedItem(R.id.nav_home);

        menu.setOnClickListener(view -> {
            if (drawerLayout1.isDrawerVisible(GravityCompat.START))
                drawerLayout1.closeDrawer(GravityCompat.START);
            else drawerLayout1.openDrawer(GravityCompat.START);
        });
    }
    private void animateNavigationDrawer() {
        drawerLayout1.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            static final float END_SCALE = 0.7f;
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView1.setScaleX(offsetScale);
                contentView1.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView1.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView1.setTranslationX(xTranslation);
            }
        });
    }
    public void onBackPressed() {
        if (drawerLayout1.isDrawerVisible(GravityCompat.START)) {
            drawerLayout1.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

   @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}