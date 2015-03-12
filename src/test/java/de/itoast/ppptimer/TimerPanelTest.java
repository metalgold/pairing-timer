package de.itoast.ppptimer;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class TimerPanelTest extends Graphics2D {
    private StringBuilder paintingResult = new StringBuilder("");
    private TimerConfiguration timerConfiguration;
    private TimerPanel timerPanel;

    @Before
    public void setUp() throws Exception {
        timerConfiguration = mock(TimerConfiguration.class);
        timerPanel = new TimerPanel(timerConfiguration);
    }

    @Test
    public void shouldDrawPie() throws Exception {
        AngleTimer timer = mock(AngleTimer.class);
        timerPanel.setTimer(timer);
        for (int i = 0; i <= 360; i++) {
            given(timer.getAngle()).willReturn((double) i);
            given(timer.getSecondsLeft()).willReturn(360 - i);
            timerPanel.paintComponent(this);
        }
        assertEquals("Start angle: 90.0\n" +
                "End angle: -0.0\n" +
                "Drawing string: 6m at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -1.0\n" +
                "Drawing string: 5m59s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -2.0\n" +
                "Drawing string: 5m58s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -3.0\n" +
                "Drawing string: 5m57s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -4.0\n" +
                "Drawing string: 5m56s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -5.0\n" +
                "Drawing string: 5m55s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -6.0\n" +
                "Drawing string: 5m54s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -7.0\n" +
                "Drawing string: 5m53s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -8.0\n" +
                "Drawing string: 5m52s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -9.0\n" +
                "Drawing string: 5m51s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -10.0\n" +
                "Drawing string: 5m50s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -11.0\n" +
                "Drawing string: 5m49s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -12.0\n" +
                "Drawing string: 5m48s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -13.0\n" +
                "Drawing string: 5m47s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -14.0\n" +
                "Drawing string: 5m46s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -15.0\n" +
                "Drawing string: 5m45s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -16.0\n" +
                "Drawing string: 5m44s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -17.0\n" +
                "Drawing string: 5m43s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -18.0\n" +
                "Drawing string: 5m42s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -19.0\n" +
                "Drawing string: 5m41s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -20.0\n" +
                "Drawing string: 5m40s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -21.0\n" +
                "Drawing string: 5m39s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -22.0\n" +
                "Drawing string: 5m38s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -23.0\n" +
                "Drawing string: 5m37s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -24.0\n" +
                "Drawing string: 5m36s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -25.0\n" +
                "Drawing string: 5m35s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -26.0\n" +
                "Drawing string: 5m34s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -27.0\n" +
                "Drawing string: 5m33s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -28.0\n" +
                "Drawing string: 5m32s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -29.0\n" +
                "Drawing string: 5m31s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -30.0\n" +
                "Drawing string: 5m30s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -31.0\n" +
                "Drawing string: 5m29s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -32.0\n" +
                "Drawing string: 5m28s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -33.0\n" +
                "Drawing string: 5m27s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -34.0\n" +
                "Drawing string: 5m26s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -35.0\n" +
                "Drawing string: 5m25s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -36.0\n" +
                "Drawing string: 5m24s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -37.0\n" +
                "Drawing string: 5m23s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -38.0\n" +
                "Drawing string: 5m22s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -39.0\n" +
                "Drawing string: 5m21s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -40.0\n" +
                "Drawing string: 5m20s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -41.0\n" +
                "Drawing string: 5m19s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -42.0\n" +
                "Drawing string: 5m18s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -43.0\n" +
                "Drawing string: 5m17s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -44.0\n" +
                "Drawing string: 5m16s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -45.0\n" +
                "Drawing string: 5m15s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -46.0\n" +
                "Drawing string: 5m14s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -47.0\n" +
                "Drawing string: 5m13s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -48.0\n" +
                "Drawing string: 5m12s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -49.0\n" +
                "Drawing string: 5m11s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -50.0\n" +
                "Drawing string: 5m10s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -51.0\n" +
                "Drawing string: 5m9s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -52.0\n" +
                "Drawing string: 5m8s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -53.0\n" +
                "Drawing string: 5m7s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -54.0\n" +
                "Drawing string: 5m6s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -55.0\n" +
                "Drawing string: 5m5s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -56.0\n" +
                "Drawing string: 5m4s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -57.0\n" +
                "Drawing string: 5m3s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -58.0\n" +
                "Drawing string: 5m2s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -59.0\n" +
                "Drawing string: 5m1s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -60.0\n" +
                "Drawing string: 5m at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -61.0\n" +
                "Drawing string: 4m59s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -62.0\n" +
                "Drawing string: 4m58s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -63.0\n" +
                "Drawing string: 4m57s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -64.0\n" +
                "Drawing string: 4m56s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -65.0\n" +
                "Drawing string: 4m55s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -66.0\n" +
                "Drawing string: 4m54s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -67.0\n" +
                "Drawing string: 4m53s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -68.0\n" +
                "Drawing string: 4m52s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -69.0\n" +
                "Drawing string: 4m51s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -70.0\n" +
                "Drawing string: 4m50s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -71.0\n" +
                "Drawing string: 4m49s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -72.0\n" +
                "Drawing string: 4m48s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -73.0\n" +
                "Drawing string: 4m47s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -74.0\n" +
                "Drawing string: 4m46s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -75.0\n" +
                "Drawing string: 4m45s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -76.0\n" +
                "Drawing string: 4m44s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -77.0\n" +
                "Drawing string: 4m43s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -78.0\n" +
                "Drawing string: 4m42s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -79.0\n" +
                "Drawing string: 4m41s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -80.0\n" +
                "Drawing string: 4m40s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -81.0\n" +
                "Drawing string: 4m39s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -82.0\n" +
                "Drawing string: 4m38s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -83.0\n" +
                "Drawing string: 4m37s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -84.0\n" +
                "Drawing string: 4m36s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -85.0\n" +
                "Drawing string: 4m35s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -86.0\n" +
                "Drawing string: 4m34s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -87.0\n" +
                "Drawing string: 4m33s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -88.0\n" +
                "Drawing string: 4m32s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -89.0\n" +
                "Drawing string: 4m31s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -90.0\n" +
                "Drawing string: 4m30s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -91.0\n" +
                "Drawing string: 4m29s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -92.0\n" +
                "Drawing string: 4m28s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -93.0\n" +
                "Drawing string: 4m27s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -94.0\n" +
                "Drawing string: 4m26s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -95.0\n" +
                "Drawing string: 4m25s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -96.0\n" +
                "Drawing string: 4m24s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -97.0\n" +
                "Drawing string: 4m23s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -98.0\n" +
                "Drawing string: 4m22s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -99.0\n" +
                "Drawing string: 4m21s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -100.0\n" +
                "Drawing string: 4m20s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -101.0\n" +
                "Drawing string: 4m19s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -102.0\n" +
                "Drawing string: 4m18s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -103.0\n" +
                "Drawing string: 4m17s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -104.0\n" +
                "Drawing string: 4m16s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -105.0\n" +
                "Drawing string: 4m15s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -106.0\n" +
                "Drawing string: 4m14s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -107.0\n" +
                "Drawing string: 4m13s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -108.0\n" +
                "Drawing string: 4m12s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -109.0\n" +
                "Drawing string: 4m11s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -110.0\n" +
                "Drawing string: 4m10s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -111.0\n" +
                "Drawing string: 4m9s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -112.0\n" +
                "Drawing string: 4m8s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -113.0\n" +
                "Drawing string: 4m7s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -114.0\n" +
                "Drawing string: 4m6s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -115.0\n" +
                "Drawing string: 4m5s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -116.0\n" +
                "Drawing string: 4m4s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -117.0\n" +
                "Drawing string: 4m3s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -118.0\n" +
                "Drawing string: 4m2s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -119.0\n" +
                "Drawing string: 4m1s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -120.0\n" +
                "Drawing string: 4m at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -121.0\n" +
                "Drawing string: 3m59s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -122.0\n" +
                "Drawing string: 3m58s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -123.0\n" +
                "Drawing string: 3m57s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -124.0\n" +
                "Drawing string: 3m56s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -125.0\n" +
                "Drawing string: 3m55s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -126.0\n" +
                "Drawing string: 3m54s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -127.0\n" +
                "Drawing string: 3m53s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -128.0\n" +
                "Drawing string: 3m52s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -129.0\n" +
                "Drawing string: 3m51s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -130.0\n" +
                "Drawing string: 3m50s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -131.0\n" +
                "Drawing string: 3m49s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -132.0\n" +
                "Drawing string: 3m48s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -133.0\n" +
                "Drawing string: 3m47s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -134.0\n" +
                "Drawing string: 3m46s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -135.0\n" +
                "Drawing string: 3m45s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -136.0\n" +
                "Drawing string: 3m44s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -137.0\n" +
                "Drawing string: 3m43s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -138.0\n" +
                "Drawing string: 3m42s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -139.0\n" +
                "Drawing string: 3m41s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -140.0\n" +
                "Drawing string: 3m40s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -141.0\n" +
                "Drawing string: 3m39s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -142.0\n" +
                "Drawing string: 3m38s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -143.0\n" +
                "Drawing string: 3m37s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -144.0\n" +
                "Drawing string: 3m36s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -145.0\n" +
                "Drawing string: 3m35s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -146.0\n" +
                "Drawing string: 3m34s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -147.0\n" +
                "Drawing string: 3m33s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -148.0\n" +
                "Drawing string: 3m32s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -149.0\n" +
                "Drawing string: 3m31s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -150.0\n" +
                "Drawing string: 3m30s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -151.0\n" +
                "Drawing string: 3m29s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -152.0\n" +
                "Drawing string: 3m28s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -153.0\n" +
                "Drawing string: 3m27s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -154.0\n" +
                "Drawing string: 3m26s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -155.0\n" +
                "Drawing string: 3m25s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -156.0\n" +
                "Drawing string: 3m24s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -157.0\n" +
                "Drawing string: 3m23s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -158.0\n" +
                "Drawing string: 3m22s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -159.0\n" +
                "Drawing string: 3m21s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -160.0\n" +
                "Drawing string: 3m20s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -161.0\n" +
                "Drawing string: 3m19s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -162.0\n" +
                "Drawing string: 3m18s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -163.0\n" +
                "Drawing string: 3m17s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -164.0\n" +
                "Drawing string: 3m16s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -165.0\n" +
                "Drawing string: 3m15s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -166.0\n" +
                "Drawing string: 3m14s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -167.0\n" +
                "Drawing string: 3m13s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -168.0\n" +
                "Drawing string: 3m12s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -169.0\n" +
                "Drawing string: 3m11s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -170.0\n" +
                "Drawing string: 3m10s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -171.0\n" +
                "Drawing string: 3m9s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -172.0\n" +
                "Drawing string: 3m8s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -173.0\n" +
                "Drawing string: 3m7s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -174.0\n" +
                "Drawing string: 3m6s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -175.0\n" +
                "Drawing string: 3m5s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -176.0\n" +
                "Drawing string: 3m4s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -177.0\n" +
                "Drawing string: 3m3s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -178.0\n" +
                "Drawing string: 3m2s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -179.0\n" +
                "Drawing string: 3m1s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -180.0\n" +
                "Drawing string: 3m at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -181.0\n" +
                "Drawing string: 2m59s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -182.0\n" +
                "Drawing string: 2m58s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -183.0\n" +
                "Drawing string: 2m57s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -184.0\n" +
                "Drawing string: 2m56s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -185.0\n" +
                "Drawing string: 2m55s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -186.0\n" +
                "Drawing string: 2m54s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -187.0\n" +
                "Drawing string: 2m53s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -188.0\n" +
                "Drawing string: 2m52s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -189.0\n" +
                "Drawing string: 2m51s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -190.0\n" +
                "Drawing string: 2m50s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -191.0\n" +
                "Drawing string: 2m49s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -192.0\n" +
                "Drawing string: 2m48s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -193.0\n" +
                "Drawing string: 2m47s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -194.0\n" +
                "Drawing string: 2m46s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -195.0\n" +
                "Drawing string: 2m45s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -196.0\n" +
                "Drawing string: 2m44s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -197.0\n" +
                "Drawing string: 2m43s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -198.0\n" +
                "Drawing string: 2m42s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -199.0\n" +
                "Drawing string: 2m41s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -200.0\n" +
                "Drawing string: 2m40s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -201.0\n" +
                "Drawing string: 2m39s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -202.0\n" +
                "Drawing string: 2m38s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -203.0\n" +
                "Drawing string: 2m37s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -204.0\n" +
                "Drawing string: 2m36s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -205.0\n" +
                "Drawing string: 2m35s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -206.0\n" +
                "Drawing string: 2m34s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -207.0\n" +
                "Drawing string: 2m33s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -208.0\n" +
                "Drawing string: 2m32s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -209.0\n" +
                "Drawing string: 2m31s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -210.0\n" +
                "Drawing string: 2m30s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -211.0\n" +
                "Drawing string: 2m29s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -212.0\n" +
                "Drawing string: 2m28s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -213.0\n" +
                "Drawing string: 2m27s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -214.0\n" +
                "Drawing string: 2m26s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -215.0\n" +
                "Drawing string: 2m25s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -216.0\n" +
                "Drawing string: 2m24s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -217.0\n" +
                "Drawing string: 2m23s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -218.0\n" +
                "Drawing string: 2m22s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -219.0\n" +
                "Drawing string: 2m21s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -220.0\n" +
                "Drawing string: 2m20s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -221.0\n" +
                "Drawing string: 2m19s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -222.0\n" +
                "Drawing string: 2m18s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -223.0\n" +
                "Drawing string: 2m17s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -224.0\n" +
                "Drawing string: 2m16s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -225.0\n" +
                "Drawing string: 2m15s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -226.0\n" +
                "Drawing string: 2m14s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -227.0\n" +
                "Drawing string: 2m13s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -228.0\n" +
                "Drawing string: 2m12s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -229.0\n" +
                "Drawing string: 2m11s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -230.0\n" +
                "Drawing string: 2m10s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -231.0\n" +
                "Drawing string: 2m9s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -232.0\n" +
                "Drawing string: 2m8s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -233.0\n" +
                "Drawing string: 2m7s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -234.0\n" +
                "Drawing string: 2m6s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -235.0\n" +
                "Drawing string: 2m5s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -236.0\n" +
                "Drawing string: 2m4s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -237.0\n" +
                "Drawing string: 2m3s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -238.0\n" +
                "Drawing string: 2m2s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -239.0\n" +
                "Drawing string: 2m1s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -240.0\n" +
                "Drawing string: 2m at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -241.0\n" +
                "Drawing string: 1m59s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -242.0\n" +
                "Drawing string: 1m58s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -243.0\n" +
                "Drawing string: 1m57s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -244.0\n" +
                "Drawing string: 1m56s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -245.0\n" +
                "Drawing string: 1m55s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -246.0\n" +
                "Drawing string: 1m54s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -247.0\n" +
                "Drawing string: 1m53s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -248.0\n" +
                "Drawing string: 1m52s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -249.0\n" +
                "Drawing string: 1m51s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -250.0\n" +
                "Drawing string: 1m50s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -251.0\n" +
                "Drawing string: 1m49s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -252.0\n" +
                "Drawing string: 1m48s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -253.0\n" +
                "Drawing string: 1m47s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -254.0\n" +
                "Drawing string: 1m46s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -255.0\n" +
                "Drawing string: 1m45s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -256.0\n" +
                "Drawing string: 1m44s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -257.0\n" +
                "Drawing string: 1m43s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -258.0\n" +
                "Drawing string: 1m42s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -259.0\n" +
                "Drawing string: 1m41s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -260.0\n" +
                "Drawing string: 1m40s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -261.0\n" +
                "Drawing string: 1m39s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -262.0\n" +
                "Drawing string: 1m38s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -263.0\n" +
                "Drawing string: 1m37s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -264.0\n" +
                "Drawing string: 1m36s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -265.0\n" +
                "Drawing string: 1m35s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -266.0\n" +
                "Drawing string: 1m34s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -267.0\n" +
                "Drawing string: 1m33s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -268.0\n" +
                "Drawing string: 1m32s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -269.0\n" +
                "Drawing string: 1m31s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -270.0\n" +
                "Drawing string: 1m30s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -271.0\n" +
                "Drawing string: 1m29s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -272.0\n" +
                "Drawing string: 1m28s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -273.0\n" +
                "Drawing string: 1m27s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -274.0\n" +
                "Drawing string: 1m26s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -275.0\n" +
                "Drawing string: 1m25s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -276.0\n" +
                "Drawing string: 1m24s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -277.0\n" +
                "Drawing string: 1m23s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -278.0\n" +
                "Drawing string: 1m22s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -279.0\n" +
                "Drawing string: 1m21s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -280.0\n" +
                "Drawing string: 1m20s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -281.0\n" +
                "Drawing string: 1m19s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -282.0\n" +
                "Drawing string: 1m18s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -283.0\n" +
                "Drawing string: 1m17s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -284.0\n" +
                "Drawing string: 1m16s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -285.0\n" +
                "Drawing string: 1m15s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -286.0\n" +
                "Drawing string: 1m14s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -287.0\n" +
                "Drawing string: 1m13s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -288.0\n" +
                "Drawing string: 1m12s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -289.0\n" +
                "Drawing string: 1m11s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -290.0\n" +
                "Drawing string: 1m10s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -291.0\n" +
                "Drawing string: 1m9s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -292.0\n" +
                "Drawing string: 1m8s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -293.0\n" +
                "Drawing string: 1m7s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -294.0\n" +
                "Drawing string: 1m6s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -295.0\n" +
                "Drawing string: 1m5s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -296.0\n" +
                "Drawing string: 1m4s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -297.0\n" +
                "Drawing string: 1m3s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -298.0\n" +
                "Drawing string: 1m2s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -299.0\n" +
                "Drawing string: 1m1s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -300.0\n" +
                "Drawing string: 1m at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -301.0\n" +
                "Drawing string: 59s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -302.0\n" +
                "Drawing string: 58s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -303.0\n" +
                "Drawing string: 57s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -304.0\n" +
                "Drawing string: 56s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -305.0\n" +
                "Drawing string: 55s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -306.0\n" +
                "Drawing string: 54s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -307.0\n" +
                "Drawing string: 53s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -308.0\n" +
                "Drawing string: 52s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -309.0\n" +
                "Drawing string: 51s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -310.0\n" +
                "Drawing string: 50s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -311.0\n" +
                "Drawing string: 49s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -312.0\n" +
                "Drawing string: 48s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -313.0\n" +
                "Drawing string: 47s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -314.0\n" +
                "Drawing string: 46s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -315.0\n" +
                "Drawing string: 45s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -316.0\n" +
                "Drawing string: 44s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -317.0\n" +
                "Drawing string: 43s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -318.0\n" +
                "Drawing string: 42s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -319.0\n" +
                "Drawing string: 41s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -320.0\n" +
                "Drawing string: 40s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -321.0\n" +
                "Drawing string: 39s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -322.0\n" +
                "Drawing string: 38s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -323.0\n" +
                "Drawing string: 37s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -324.0\n" +
                "Drawing string: 36s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -325.0\n" +
                "Drawing string: 35s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -326.0\n" +
                "Drawing string: 34s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -327.0\n" +
                "Drawing string: 33s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -328.0\n" +
                "Drawing string: 32s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -329.0\n" +
                "Drawing string: 31s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -330.0\n" +
                "Drawing string: 30s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -331.0\n" +
                "Drawing string: 29s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -332.0\n" +
                "Drawing string: 28s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -333.0\n" +
                "Drawing string: 27s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -334.0\n" +
                "Drawing string: 26s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -335.0\n" +
                "Drawing string: 25s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -336.0\n" +
                "Drawing string: 24s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -337.0\n" +
                "Drawing string: 23s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -338.0\n" +
                "Drawing string: 22s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -339.0\n" +
                "Drawing string: 21s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -340.0\n" +
                "Drawing string: 20s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -341.0\n" +
                "Drawing string: 19s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -342.0\n" +
                "Drawing string: 18s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -343.0\n" +
                "Drawing string: 17s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -344.0\n" +
                "Drawing string: 16s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -345.0\n" +
                "Drawing string: 15s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -346.0\n" +
                "Drawing string: 14s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -347.0\n" +
                "Drawing string: 13s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -348.0\n" +
                "Drawing string: 12s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -349.0\n" +
                "Drawing string: 11s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -350.0\n" +
                "Drawing string: 10s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -351.0\n" +
                "Drawing string: 9s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -352.0\n" +
                "Drawing string: 8s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -353.0\n" +
                "Drawing string: 7s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -354.0\n" +
                "Drawing string: 6s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -355.0\n" +
                "Drawing string: 5s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -356.0\n" +
                "Drawing string: 4s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -357.0\n" +
                "Drawing string: 3s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -358.0\n" +
                "Drawing string: 2s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -359.0\n" +
                "Drawing string: 1s at 0/24\n" +
                "Start angle: 90.0\n" +
                "End angle: -360.0\n" +
                "Drawing string:  at 0/24\n", paintingResult.toString());
    }

    @Test
    public void shouldReturnStartTextWhenTimerIsCancelled() throws Exception {
        AngleTimer timer = mock(AngleTimer.class);
        timerPanel.setTimer(timer);
        given(timer.isCancelled()).willReturn(true);
        assertEquals("Start timer", timerPanel.getToggleText());
    }

    @Test
    public void shouldShowStopTextWhenTimerIsRunning() throws Exception {
        AngleTimer timer = mock(AngleTimer.class);
        timerPanel.setTimer(timer);
        given(timer.isCancelled()).willReturn(false);
        assertEquals("Stop timer", timerPanel.getToggleText());


    }

    @Override
    public void draw(Shape s) {

    }

    @Override
    public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
        return false;
    }

    @Override
    public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {

    }

    @Override
    public void drawRenderedImage(RenderedImage img, AffineTransform xform) {

    }

    @Override
    public void drawRenderableImage(RenderableImage img, AffineTransform xform) {

    }

    @Override
    public void drawString(String str, int x, int y) {
        paintingResult.append("Drawing string: ");
        paintingResult.append(str);
        paintingResult.append(" at ");
        paintingResult.append(x);
        paintingResult.append("/");
        paintingResult.append(y);
        paintingResult.append("\n");
    }

    @Override
    public void drawString(String str, float x, float y) {

    }

    @Override
    public void drawString(AttributedCharacterIterator iterator, int x, int y) {

    }

    @Override
    public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
        return false;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void drawString(AttributedCharacterIterator iterator, float x, float y) {

    }

    @Override
    public void drawGlyphVector(GlyphVector g, float x, float y) {

    }

    @Override
    public void fill(Shape s) {
        if (s instanceof Arc2D) {
            Arc2D a = (Arc2D) s;
            this.paintingResult.append("Start angle: ");
            this.paintingResult.append(a.getAngleStart());
            this.paintingResult.append("\n");
            this.paintingResult.append("End angle: ");
            this.paintingResult.append(a.getAngleExtent());
            this.paintingResult.append("\n");
        }
    }

    @Override
    public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
        return false;
    }

    @Override
    public GraphicsConfiguration getDeviceConfiguration() {
        return null;
    }

    @Override
    public void setComposite(Composite comp) {

    }

    @Override
    public void setPaint(Paint paint) {

    }

    @Override
    public void setStroke(Stroke s) {

    }

    @Override
    public void setRenderingHint(RenderingHints.Key hintKey, Object hintValue) {

    }

    @Override
    public Object getRenderingHint(RenderingHints.Key hintKey) {
        return null;
    }

    @Override
    public void setRenderingHints(Map<?, ?> hints) {

    }

    @Override
    public void addRenderingHints(Map<?, ?> hints) {

    }

    @Override
    public RenderingHints getRenderingHints() {
        return null;
    }

    @Override
    public Graphics create() {
        return this;
    }

    @Override
    public void translate(int x, int y) {

    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public void setColor(Color c) {

    }

    @Override
    public void setPaintMode() {

    }

    @Override
    public void setXORMode(Color c1) {

    }

    @Override
    public Font getFont() {
        return null;
    }

    @Override
    public void setFont(Font font) {

    }

    @Override
    public FontMetrics getFontMetrics(Font f) {
        return null;
    }

    @Override
    public Rectangle getClipBounds() {
        return null;
    }

    @Override
    public void clipRect(int x, int y, int width, int height) {

    }

    @Override
    public void setClip(int x, int y, int width, int height) {

    }

    @Override
    public Shape getClip() {
        return null;
    }

    @Override
    public void setClip(Shape clip) {

    }

    @Override
    public void copyArea(int x, int y, int width, int height, int dx, int dy) {

    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {

    }

    @Override
    public void fillRect(int x, int y, int width, int height) {

    }

    @Override
    public void clearRect(int x, int y, int width, int height) {

    }

    @Override
    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

    }

    @Override
    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

    }

    @Override
    public void drawOval(int x, int y, int width, int height) {

    }

    @Override
    public void fillOval(int x, int y, int width, int height) {

    }

    @Override
    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

    }

    @Override
    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

    }

    @Override
    public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {

    }

    @Override
    public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

    }

    @Override
    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {

    }

    @Override
    public void translate(double tx, double ty) {

    }

    @Override
    public void rotate(double theta) {

    }

    @Override
    public void rotate(double theta, double x, double y) {

    }

    @Override
    public void scale(double sx, double sy) {

    }

    @Override
    public void shear(double shx, double shy) {

    }

    @Override
    public void transform(AffineTransform Tx) {

    }

    @Override
    public void setTransform(AffineTransform Tx) {

    }

    @Override
    public AffineTransform getTransform() {
        return null;
    }

    @Override
    public Paint getPaint() {
        return null;
    }

    @Override
    public Composite getComposite() {
        return null;
    }

    @Override
    public void setBackground(Color color) {

    }

    @Override
    public Color getBackground() {
        return null;
    }

    @Override
    public Stroke getStroke() {
        return null;
    }

    @Override
    public void clip(Shape s) {

    }

    @Override
    public FontRenderContext getFontRenderContext() {
        return null;
    }
}