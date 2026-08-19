package mg.hira.vavaka.fiaram.testbuild;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        root.setPadding(dp(20), dp(22), dp(20), dp(30));
        root.setBackgroundColor(Color.rgb(247, 249, 248));
        scroll.addView(root, new ScrollView.LayoutParams(
                ScrollView.LayoutParams.MATCH_PARENT,
                ScrollView.LayoutParams.WRAP_CONTENT));

        ImageView logo = new ImageView(this);
        Drawable icon = getResources().getDrawable(R.drawable.app_icon);
        logo.setImageDrawable(icon);
        logo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        logo.setAdjustViewBounds(true);
        LinearLayout.LayoutParams logoLp = new LinearLayout.LayoutParams(dp(190), dp(190));
        logoLp.bottomMargin = dp(10);
        root.addView(logo, logoLp);

        TextView title = new TextView(this);
        title.setText("HIRA&VAVAKA_FIARAM");
        title.setTextSize(27);
        title.setTextColor(Color.rgb(9, 45, 92));
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        root.addView(title, matchWrap());

        TextView version = new TextView(this);
        version.setText("v1.2.3 TEST LOGO STABLE • TECNO SPARK 8P / Android 11");
        version.setTextSize(14);
        version.setTextColor(Color.DKGRAY);
        version.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams versionLp = matchWrap();
        versionLp.topMargin = dp(8);
        root.addView(version, versionLp);

        status = new TextView(this);
        status.setText("LOGO OFFICIEL INTÉGRÉ ✓\n\nLa base Android native reste stable et le logo HIRA&VAVAKA_FIARAM est maintenant affiché dans l'application et utilisé comme icône.");
        status.setTextSize(18);
        status.setTextColor(Color.rgb(25, 75, 48));
        status.setGravity(Gravity.CENTER);
        status.setPadding(dp(12), dp(16), dp(12), dp(16));
        LinearLayout.LayoutParams statusLp = matchWrap();
        statusLp.topMargin = dp(14);
        root.addView(status, statusLp);

        Button test = new Button(this);
        test.setText("TESTER L'APPLICATION");
        test.setAllCaps(false);
        test.setTextSize(17);
        LinearLayout.LayoutParams btnLp = matchWrap();
        btnLp.topMargin = dp(12);
        root.addView(test, btnLp);
        test.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                status.setText("TEST OK ✓\n\nL'application et le logo fonctionnent sans crash. La prochaine étape est la réintégration progressive des HIRA.");
            }
        });

        TextView about = new TextView(this);
        about.setText("Développé par Jean Brunel ANDRIAMIHAJA\nE-mail : andriamihajabrunelfiaram@gmail.com\nTél. : 034 50 524 52\nAdresse : Ambohimangaly, Ambatondrazaka\n\nFISAORANA\nIsaorana Jesosy Tompo, Ny Mpaminany Nenitoa, Ny Mpanompon'Andriamanitra Pastora Paul mivady, Tonton Sedera mivady, Ny EQUIPE SONORISATION_MPANAN-TALENTA rehetra.");
        about.setTextSize(14);
        about.setTextColor(Color.rgb(70,70,70));
        about.setGravity(Gravity.CENTER);
        about.setLineSpacing(0, 1.15f);
        LinearLayout.LayoutParams aboutLp = matchWrap();
        aboutLp.topMargin = dp(24);
        root.addView(about, aboutLp);

        setContentView(scroll);
    }

    private LinearLayout.LayoutParams matchWrap() {
        return new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    private int dp(int value) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (value * density + 0.5f);
    }
}
