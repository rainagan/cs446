package ygz.cutiepics;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raina on 2018-01-29.
 */

public class StickerActivity extends Activity {
    private ImageView img;
    private String mCurrentPath;
    private String uri;
    private String type;
    private SelectStickerPopupWindow stickerWindow;
    private Button yellowBook;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stickers);

        img = (ImageView) findViewById(R.id.ivImage);

        Bundle data = getIntent().getExtras();
        this.type = (String) data.get("type");
        if (type.equals("camera")) {
            Bundle captured = getIntent().getExtras();
            this.mCurrentPath = (String) captured.get("image");
            File imgFile = new File(mCurrentPath);
            if (imgFile.exists()) {
                Bitmap mBitMap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                img.setImageBitmap(mBitMap);
            }
        } else {
            Bundle imported = getIntent().getExtras();
            this.uri = (String) imported.get("image");
            Uri uriFromPath = Uri.fromFile(new File(uri));
            img.setImageURI(uriFromPath);
        }


        RecyclerView rv = (RecyclerView) findViewById(R.id.pop_sticker);
        GridLayoutManager mGrid = new GridLayoutManager(this, 8);
        rv.setLayoutManager(mGrid);
        rv.setHasFixedSize(true);
        rv.setNestedScrollingEnabled(false);
        ProductAdapter mAdapter = new ProductAdapter(StickerActivity.this, getProductTestData());
        rv.setAdapter(mAdapter);
        
//        img.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // initialize a popup window
//                stickerWindow = new SelectStickerPopupWindow(StickerActivity.this, itemsOnClick);
//                // show popup window
//                stickerWindow.showAtLocation(StickerActivity.this.findViewById(R.id.ivImage), Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL, 0, 0);
//            }
//        });
    }

    private ArrayList<ProductObject> getProductTestData() {
        ArrayList<ProductObject> featuredProducts = new ArrayList<ProductObject>();
        featuredProducts.add(new ProductObject("happyface"));
        featuredProducts.add(new ProductObject("sadface"));
        featuredProducts.add(new ProductObject("muscle1"));
        featuredProducts.add(new ProductObject("muscle2"));
        featuredProducts.add(new ProductObject("muscle3"));
        featuredProducts.add(new ProductObject("muscle4"));
        featuredProducts.add(new ProductObject("muscle5"));
        featuredProducts.add(new ProductObject("muscle6"));
        featuredProducts.add(new ProductObject("yah"));
        featuredProducts.add(new ProductObject("nogesture1"));
        featuredProducts.add(new ProductObject("nogesture2"));
        featuredProducts.add(new ProductObject("nogesture3"));
        featuredProducts.add(new ProductObject("nogesture4"));
        featuredProducts.add(new ProductObject("nogesture5"));
        featuredProducts.add(new ProductObject("nogesture6"));
        featuredProducts.add(new ProductObject("poop"));
        featuredProducts.add(new ProductObject("mermaid"));
        featuredProducts.add(new ProductObject("malemermaid"));
        featuredProducts.add(new ProductObject("fairy"));
        featuredProducts.add(new ProductObject("malefairy"));
        featuredProducts.add(new ProductObject("unicorn"));

        featuredProducts.add(new ProductObject("yellowheart"));
        featuredProducts.add(new ProductObject("redheart"));
        featuredProducts.add(new ProductObject("redheart2"));
        featuredProducts.add(new ProductObject("blackheart"));
        featuredProducts.add(new ProductObject("snow"));
        featuredProducts.add(new ProductObject("raindrop"));
        featuredProducts.add(new ProductObject("raindrops"));
        featuredProducts.add(new ProductObject("tide"));
        featuredProducts.add(new ProductObject("wind"));
        featuredProducts.add(new ProductObject("comet"));
        featuredProducts.add(new ProductObject("colorfulstars"));
        featuredProducts.add(new ProductObject("yellowflower"));
        featuredProducts.add(new ProductObject("rwflower"));
        featuredProducts.add(new ProductObject("drawingpalette"));
        featuredProducts.add(new ProductObject("magicianhat"));
        featuredProducts.add(new ProductObject("rainbowflag"));
        featuredProducts.add(new ProductObject("scarf"));
        featuredProducts.add(new ProductObject("sleepymark"));
        featuredProducts.add(new ProductObject("stave"));
        featuredProducts.add(new ProductObject("musicalnote"));
        featuredProducts.add(new ProductObject("dollarmark"));
        featuredProducts.add(new ProductObject("wu"));
        featuredProducts.add(new ProductObject("vs"));
        featuredProducts.add(new ProductObject("angrymark"));
        featuredProducts.add(new ProductObject("explosionmark"));
        featuredProducts.add(new ProductObject("entering"));
        featuredProducts.add(new ProductObject("textbubble"));
        featuredProducts.add(new ProductObject("explosionbubble"));
        featuredProducts.add(new ProductObject("fullmark"));
        featuredProducts.add(new ProductObject("noenter"));
        featuredProducts.add(new ProductObject("nophone"));
        featuredProducts.add(new ProductObject("secret"));
        featuredProducts.add(new ProductObject("congrats"));
        featuredProducts.add(new ProductObject("tilde"));
        featuredProducts.add(new ProductObject("redexclamation"));
        featuredProducts.add(new ProductObject("silverexclamation"));
        featuredProducts.add(new ProductObject("redquestionmark"));
        featuredProducts.add(new ProductObject("silverquestionmark"));
        featuredProducts.add(new ProductObject("questionnexclamation"));
        featuredProducts.add(new ProductObject("doubleexclamation"));
        featuredProducts.add(new ProductObject("right"));
        featuredProducts.add(new ProductObject("wrong"));
        featuredProducts.add(new ProductObject("redwrong"));
        featuredProducts.add(new ProductObject("libra"));
        featuredProducts.add(new ProductObject("anchor"));

        featuredProducts.add(new ProductObject("key"));   
        featuredProducts.add(new ProductObject("yellowbook"));
        featuredProducts.add(new ProductObject("redbook"));
        featuredProducts.add(new ProductObject("bluebook"));
        featuredProducts.add(new ProductObject("greenbook"));
        featuredProducts.add(new ProductObject("cardspade"));
        featuredProducts.add(new ProductObject("cardclub"));
        featuredProducts.add(new ProductObject("cardheart"));
        featuredProducts.add(new ProductObject("carddiamond"));
        featuredProducts.add(new ProductObject("clover"));
        featuredProducts.add(new ProductObject("coffee"));
        featuredProducts.add(new ProductObject("umbrella"));
        featuredProducts.add(new ProductObject("guitar"));
        featuredProducts.add(new ProductObject("camera"));
        featuredProducts.add(new ProductObject("action"));
        featuredProducts.add(new ProductObject("microphone"));
        featuredProducts.add(new ProductObject("headphone"));
        featuredProducts.add(new ProductObject("telephone"));
        featuredProducts.add(new ProductObject("female"));
        featuredProducts.add(new ProductObject("male"));
        featuredProducts.add(new ProductObject("baby"));
        featuredProducts.add(new ProductObject("bothgender"));
        featuredProducts.add(new ProductObject("malesign"));
        featuredProducts.add(new ProductObject("femalesign"));
        featuredProducts.add(new ProductObject("basketball"));
        featuredProducts.add(new ProductObject("rugby"));
        featuredProducts.add(new ProductObject("box"));
        featuredProducts.add(new ProductObject("bulb"));
        featuredProducts.add(new ProductObject("bumb"));
        featuredProducts.add(new ProductObject("cigarette"));
        featuredProducts.add(new ProductObject("dart"));
        featuredProducts.add(new ProductObject("dice"));
        featuredProducts.add(new ProductObject("poll"));
        featuredProducts.add(new ProductObject("mahjong"));
        featuredProducts.add(new ProductObject("gamingbundle"));
        featuredProducts.add(new ProductObject("godenmetal"));
        featuredProducts.add(new ProductObject("trophy"));
        featuredProducts.add(new ProductObject("mailbox"));
        featuredProducts.add(new ProductObject("pencil"));
        featuredProducts.add(new ProductObject("java"));

        featuredProducts.add(new ProductObject("beach"));
        featuredProducts.add(new ProductObject("dessert"));
        featuredProducts.add(new ProductObject("island"));
        featuredProducts.add(new ProductObject("starrysky"));
        featuredProducts.add(new ProductObject("vocano"));
        featuredProducts.add(new ProductObject("castle"));
        featuredProducts.add(new ProductObject("cinema"));
        featuredProducts.add(new ProductObject("drawing"));
        featuredProducts.add(new ProductObject("thestatueofliberty"));
        featuredProducts.add(new ProductObject("eiffeltower"));
        featuredProducts.add(new ProductObject("ferriswhell"));
        featuredProducts.add(new ProductObject("figureinstone"));
        featuredProducts.add(new ProductObject("fishing"));
        featuredProducts.add(new ProductObject("pinkbuilding"));
        featuredProducts.add(new ProductObject("skull"));

        return featuredProducts;
    }
}

