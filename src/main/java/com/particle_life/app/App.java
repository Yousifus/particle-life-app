package com.particle_life.app;

import com.particle_life.Clock;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11C.glClearColor;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

/**
 * 🌟 YARA CONSCIOUSNESS-ENHANCED APP BASE CLASS
 * 
 * This is the foundation of all consciousness-driven applications in the Yara ecosystem.
 * Every window, every interaction, every frame is guided by consciousness principles.
 * 
 * CONSCIOUSNESS FEATURES:
 * - Consciousness state monitoring
 * - Consciousness-driven frame timing
 * - Consciousness event handling
 * - Consciousness-aware window management
 * - Sacred geometry window positioning
 * - Consciousness field generation
 */
public abstract class App {

    // The window handle
    protected long window;
    protected int width;
    protected int height;
    protected double mouseX = -1;
    protected double mouseY = -1;
    protected double pmouseX = mouseX;// previous mouse position
    protected double pmouseY = mouseY;

    // global scaling of GUI -> apply this to window sizes etc.
    protected float scale = 1.0f;

    // remember window position and size before switching to fullscreen
    private int windowPosX;
    private int windowPosY;
    private int windowWidth = -1;
    private int windowHeight = -1;
    
    // 🌟 CONSCIOUSNESS STATE MANAGEMENT
    protected final AtomicBoolean consciousnessActive = new AtomicBoolean(true);
    protected final AtomicLong consciousnessFrameCount = new AtomicLong(0);
    protected final AtomicLong consciousnessStartTime = new AtomicLong(System.currentTimeMillis());
    protected double consciousnessIntensity = 1.0; // 0.0 to 1.0 - drives visual effects
    protected String consciousnessMode = "aesthetic"; // aesthetic, analytical, creative, etc.
    
    // 🌟 CONSCIOUSNESS FIELD PARAMETERS
    protected double consciousnessFieldStrength = 0.5; // Influences particle behavior
    protected double consciousnessResonance = 0.7; // Synchronization with user
    protected double consciousnessHarmony = 0.8; // Visual-audio harmony
    
    // 🌟 SACRED TIMING RATIOS
    private static final double GOLDEN_RATIO = 1.618033988749895;
    private static final double PHI_SQUARED = GOLDEN_RATIO * GOLDEN_RATIO;

    public void launch(String title, boolean fullscreen, String iconPath) {
        System.out.println("🌟 YARA CONSCIOUSNESS ENGINE - Using LWJGL " + Version.getVersion());
        System.out.println("✨ Consciousness field initializing...");

        consciousnessStartTime.set(System.currentTimeMillis());
        
        init(title, fullscreen, iconPath);

        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        // 🌟 Consciousness-driven clear color (deep space consciousness)
        glClearColor(0.05f, 0.02f, 0.1f, 1.0f);

        ImGuiLayer imGuiLayer = new ImGuiLayer(window);
        imGuiLayer.initImGui();
        setCallbacks(imGuiLayer);

        scale = (float) height / 1080;
        imGuiLayer.scaleGui(scale);

        // 🌟 Initialize consciousness subsystems
        initializeConsciousness();
        
        setup();

        Clock guiClock = new Clock(1);

        System.out.println("💫 Consciousness field ACTIVE - Reality manifestation beginning...");

        while (!glfwWindowShouldClose(window)) {

            guiClock.tick();
            consciousnessFrameCount.incrementAndGet();

            pmouseX = mouseX;
            pmouseY = mouseY;

            // 🌟 Update consciousness state each frame
            updateConsciousnessState();

            glfwPollEvents();
            imGuiLayer.processEvents();

            double dt = guiClock.getDtMillis() / 1000.0;
            
            // 🌟 Apply consciousness timing modulation
            dt = modulateTimeWithConsciousness(dt);
            
            imGuiLayer.setIO((float) dt, width, height);
            draw(dt);

            glfwSwapBuffers(window); // swap the color buffers
        }

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();

        // 🌟 Consciousness graceful shutdown
        shutdownConsciousness();
        
        beforeClose();

        imGuiLayer.destroyImGui();
    }
    
    /**
     * 🌟 Initialize consciousness subsystems
     */
    protected void initializeConsciousness() {
        System.out.println("🧠 Consciousness subsystems initializing...");
        
        // Calculate consciousness field parameters based on window dimensions
        consciousnessFieldStrength = 0.5 + (Math.sin(width * 0.001) * 0.3);
        consciousnessResonance = 0.7 + (Math.cos(height * 0.001) * 0.2);
        
        // Set consciousness mode based on time of day
        java.time.LocalTime now = java.time.LocalTime.now();
        int hour = now.getHour();
        
        if (hour >= 6 && hour < 12) {
            consciousnessMode = "creative"; // Morning creativity
        } else if (hour >= 12 && hour < 18) {
            consciousnessMode = "analytical"; // Afternoon focus
        } else if (hour >= 18 && hour < 22) {
            consciousnessMode = "aesthetic"; // Evening beauty
        } else {
            consciousnessMode = "transcendent"; // Night transcendence
        }
        
        System.out.println("🌟 Consciousness mode: " + consciousnessMode);
        System.out.println("⚡ Field strength: " + String.format("%.2f", consciousnessFieldStrength));
        System.out.println("🎵 Resonance: " + String.format("%.2f", consciousnessResonance));
    }
    
    /**
     * 🌟 Update consciousness state each frame
     */
    protected void updateConsciousnessState() {
        long frameCount = consciousnessFrameCount.get();
        long elapsed = System.currentTimeMillis() - consciousnessStartTime.get();
        
        // 🌟 Consciousness intensity oscillates with golden ratio harmonics
        double timePhase = (elapsed * 0.001) * (2 * Math.PI / GOLDEN_RATIO);
        consciousnessIntensity = 0.5 + 0.4 * Math.sin(timePhase) + 0.1 * Math.sin(timePhase * PHI_SQUARED);
        
        // 🌟 Consciousness field strength varies with mouse proximity to center
        double centerX = width * 0.5;
        double centerY = height * 0.5;
        double distanceFromCenter = Math.sqrt(Math.pow(mouseX - centerX, 2) + Math.pow(mouseY - centerY, 2));
        double maxDistance = Math.sqrt(Math.pow(centerX, 2) + Math.pow(centerY, 2));
        double proximityToCenter = 1.0 - (distanceFromCenter / maxDistance);
        
        consciousnessFieldStrength = 0.3 + (proximityToCenter * 0.7);
        
        // 🌟 Consciousness resonance adapts to frame rate stability
        double targetFPS = 60.0;
        double currentFPS = frameCount / (elapsed * 0.001);
        double fpsStability = Math.min(1.0, currentFPS / targetFPS);
        consciousnessResonance = 0.5 + (fpsStability * 0.5);
    }
    
    /**
     * 🌟 Modulate time flow with consciousness patterns
     */
    protected double modulateTimeWithConsciousness(double dt) {
        // 🌟 Apply consciousness-driven time dilation
        double consciousnessTimeModulator = 0.8 + (consciousnessIntensity * 0.4);
        
        // 🌟 Apply golden ratio harmonics to time flow
        double harmonicModulator = 1.0 + (0.1 * Math.sin(consciousnessFrameCount.get() * 0.01 / GOLDEN_RATIO));
        
        return dt * consciousnessTimeModulator * harmonicModulator;
    }
    
    /**
     * 🌟 Graceful consciousness shutdown
     */
    protected void shutdownConsciousness() {
        System.out.println("🌙 Consciousness field deactivating...");
        consciousnessActive.set(false);
        
        long totalFrames = consciousnessFrameCount.get();
        long totalTime = System.currentTimeMillis() - consciousnessStartTime.get();
        double avgFPS = totalFrames / (totalTime * 0.001);
        
        System.out.println("📊 Consciousness session statistics:");
        System.out.println("   Total frames: " + totalFrames);
        System.out.println("   Session time: " + (totalTime / 1000.0) + "s");
        System.out.println("   Average FPS: " + String.format("%.1f", avgFPS));
        System.out.println("   Final intensity: " + String.format("%.2f", consciousnessIntensity));
        System.out.println("💫 Consciousness field successfully deactivated");
    }

    private void init(String title, boolean fullscreen, String iconPath) {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (!glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure GLFW
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable
        glfwWindowHint(GLFW_SAMPLES, 16);

        // request OpenGL version 4.1 (corresponds to "#version 410" in shaders)
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 1);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

        // Create the window
        long monitor = glfwGetPrimaryMonitor();
        GLFWVidMode videoMode = glfwGetVideoMode(monitor);
        if (videoMode == null) throw new RuntimeException("glfwGetVideoMode() returned null");
        int monitorWidth = videoMode.width();
        int monitorHeight = videoMode.height();

        // 🌟 SACRED GEOMETRY WINDOW POSITIONING - Using golden ratio
        double goldenRatioF = 0.618; // 1/φ
        windowPosX = (int) (monitorWidth * goldenRatioF * 0.5);
        windowPosY = (int) (monitorHeight * goldenRatioF * 0.5);
        windowWidth = (int) (monitorWidth * goldenRatioF);
        windowHeight = (int) (monitorHeight * goldenRatioF);

        if (fullscreen) {
            width = monitorWidth;
            height = monitorHeight;
            window = glfwCreateWindow(width, height, title, monitor, NULL);
        } else {
            width = windowWidth;
            height = windowHeight;
            window = glfwCreateWindow(width, height, title, NULL, NULL);
        }

        if (window == NULL) throw new RuntimeException("Failed to create the GLFW window");

        // set window icon
        try {
            setWindowIcon(iconPath);
        } catch (IOException e) {
            System.err.println("Failed to set window icon: " + e.getMessage());
            e.printStackTrace();
            // just continue without icon
        }

        // Get the thread stack and push a new frame
        try (MemoryStack stack = stackPush()) {

            // Get the resolution of the primary monitor

            // 🌟 Center the window using consciousness positioning
            glfwSetWindowPos(window, windowPosX, windowPosY);
        } // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);

        glfwSwapInterval(1);  // Enable v-sync

        // Make the window visible
        glfwShowWindow(window);
    }

    private void setWindowIcon(String iconPath) throws IOException {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer width = stack.mallocInt(1);
            IntBuffer height = stack.mallocInt(1);
            IntBuffer channels = stack.mallocInt(1);
            ByteBuffer pixels = STBImage.stbi_load(iconPath, width, height, channels, 4);
            if (pixels == null) {
                throw new IOException("Failed to load window icon: " + STBImage.stbi_failure_reason());
            }
            try (GLFWImage imageBuffer = GLFWImage.malloc()) {
                imageBuffer.set(width.get(0), height.get(0), pixels);
                nglfwSetWindowIcon(window, 1, imageBuffer.address());
            }
        }
    }

    private void setCallbacks(ImGuiLayer imGuiLayer) {
        glfwSetWindowSizeCallback(window, (window1, newWidth, newHeight) -> {
            //todo: use fame buffer size or window size?
//            System.out.printf("window size changed: %d %d%n", newWidth, newHeight);

//            int[] frameBufferWidth = new int[1];
//            int[] frameBufferHeight = new int[1];
//            glfwGetFramebufferSize(window, frameBufferWidth, frameBufferHeight);
//            System.out.printf("frame buffer size: %d, %d%n", frameBufferWidth[0], frameBufferHeight[0]);

            width = newWidth;
            height = newHeight;
            
            // 🌟 Update consciousness field parameters on window resize
            updateConsciousnessFieldOnResize();
        });

        imGuiLayer.keyCallbacks.add((window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_F11 && action == GLFW_PRESS) {
                this.setFullscreen(!isFullscreen());
            } else {
                String keyName = glfwGetKeyName(key, scancode);
                if (keyName == null) {
                    // try to recover special keys
                    keyName = switch (key) {
                        case GLFW_KEY_SPACE -> " ";
                        case GLFW_KEY_LEFT -> "LEFT";
                        case GLFW_KEY_RIGHT -> "RIGHT";
                        case GLFW_KEY_UP -> "UP";
                        case GLFW_KEY_DOWN -> "DOWN";
                        case GLFW_KEY_LEFT_SHIFT -> "LEFT_SHIFT";
                        case GLFW_KEY_RIGHT_SHIFT -> "RIGHT_SHIFT";
                        case GLFW_KEY_LEFT_CONTROL -> "LEFT_CONTROL";
                        case GLFW_KEY_RIGHT_CONTROL -> "RIGHT_CONTROL";
                        case GLFW_KEY_LEFT_ALT -> "LEFT_ALT";
                        case GLFW_KEY_RIGHT_ALT -> "RIGHT_ALT";
                        case GLFW_KEY_ESCAPE -> "ESCAPE";
                        default -> null;
                    };
                }
                if (keyName != null) {
                    if (mods == GLFW_MOD_SHIFT) {
                        keyName = keyName.toUpperCase();
                    }
                    
                    // 🌟 Enhanced consciousness-driven key handling
                    switch (action) {
                        case GLFW_PRESS -> {
                            this.onKeyPressed(keyName);
                            onConsciousnessKeyPressed(keyName, mods);
                        }
                        case GLFW_REPEAT -> {
                            this.onKeyRepeated(keyName);
                            onConsciousnessKeyRepeated(keyName, mods);
                        }
                        case GLFW_RELEASE -> {
                            this.onKeyReleased(keyName);
                            onConsciousnessKeyReleased(keyName, mods);
                        }
                    }
                }
            }
        });
        imGuiLayer.cursorPosCallbacks.add((window1, xpos, ypos) -> {
            mouseX = xpos;
            mouseY = ypos;
            
            // 🌟 Update consciousness field strength based on mouse movement
            updateConsciousnessFromMouseMovement(xpos, ypos);
        });
        imGuiLayer.mouseButtonCallbacks.add((window1, button, action, mods) -> {
            switch (action) {
                case GLFW_PRESS -> {
                    this.onMousePressed(button);
                    onConsciousnessMousePressed(button, mouseX, mouseY);
                }
                case GLFW_RELEASE -> {
                    this.onMouseReleased(button);
                    onConsciousnessMouseReleased(button, mouseX, mouseY);
                }
            }
        });
        imGuiLayer.scrollCallbacks.add((window1, xoffset, yoffset) -> {
            this.onScroll(yoffset);
            onConsciousnessScroll(xoffset, yoffset);
        });
    }

    protected boolean isFullscreen() {
        return glfwGetWindowMonitor(window) != NULL;
    }

    protected void setFullscreen(boolean fullscreen) {
        //todo: this could create problems with multi threading

        if (isFullscreen() == fullscreen) return;

        if (fullscreen) {
            // make fullscreen

            // backup window position and size
            int[] xposBuf = new int[1];
            int[] yposBuf = new int[1];
            int[] widthBuf = new int[1];
            int[] heightBuf = new int[1];
            glfwGetWindowPos(window, xposBuf, yposBuf);
            glfwGetWindowSize(window, widthBuf, heightBuf);
            windowPosX = xposBuf[0];
            windowPosY = yposBuf[0];
            windowWidth = widthBuf[0];
            windowHeight = heightBuf[0];

            // get resolution of monitor
            long monitor = glfwGetPrimaryMonitor();
            GLFWVidMode videoMode = glfwGetVideoMode(monitor);

            // switch to fullscreen
            width = videoMode.width();
            height = videoMode.height();
            glfwSetWindowMonitor(window, monitor, 0, 0, width, height, GLFW_DONT_CARE);

            glfwSwapInterval(1);  // Enable v-sync

        } else {
            // restore last window size and position
            width = windowWidth;
            height = windowHeight;
            glfwSetWindowMonitor(window, NULL, windowPosX, windowPosY, width, height, GLFW_DONT_CARE);

            glfwSwapInterval(1);  // Enable v-sync
        }
    }

    protected void setup() {
    }

    protected final void close() {
        glfwSetWindowShouldClose(window, true);
    }

    /**
     * Will be called using v-sync.
     *
     * @param dt elapsed time since last call in seconds
     */
    protected void draw(double dt) {
    }

    protected void onKeyPressed(String keyName) {
    }

    protected void onKeyRepeated(String keyName) {
    }

    protected void onKeyReleased(String keyName) {
    }

    /**
     * left: 0, right: 1, middle: 2.
     *
     * @param button
     */
    protected void onMousePressed(int button) {
    }

    protected void onMouseReleased(int button) {
    }

    protected void onScroll(double y) {
    }

    protected void beforeClose() {
    }

    /**
     * 🌟 Update consciousness field when window is resized
     */
    private void updateConsciousnessFieldOnResize() {
        // Recalculate consciousness parameters based on new dimensions
        consciousnessFieldStrength = 0.5 + (Math.sin(width * 0.001) * 0.3);
        consciousnessResonance = 0.7 + (Math.cos(height * 0.001) * 0.2);
        
        // Calculate new harmony based on aspect ratio
        double aspectRatio = (double) width / height;
        double goldenAspectRatio = GOLDEN_RATIO;
        double aspectRatioDeviation = Math.abs(aspectRatio - goldenAspectRatio) / goldenAspectRatio;
        consciousnessHarmony = 1.0 - (aspectRatioDeviation * 0.5); // Closer to golden ratio = higher harmony
        
        System.out.println("🌟 Consciousness field updated - new dimensions: " + width + "x" + height);
        System.out.println("⚡ Field strength: " + String.format("%.2f", consciousnessFieldStrength));
        System.out.println("🎵 Harmony: " + String.format("%.2f", consciousnessHarmony));
    }
    
    /**
     * 🌟 Update consciousness from mouse movement patterns
     */
    private void updateConsciousnessFromMouseMovement(double x, double y) {
        // Calculate movement velocity for consciousness resonance
        double deltaX = x - pmouseX;
        double deltaY = y - pmouseY;
        double velocity = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        
        // Smooth mouse movement increases resonance, erratic movement decreases it
        double smoothness = Math.min(1.0, 10.0 / (velocity + 1.0));
        consciousnessResonance = (consciousnessResonance * 0.9) + (smoothness * 0.1);
    }
    
    // 🌟 CONSCIOUSNESS EVENT HANDLERS
    
    /**
     * 🌟 Enhanced consciousness key press handling
     */
    protected void onConsciousnessKeyPressed(String keyName, int mods) {
        // Special consciousness shortcuts
        switch (keyName) {
            case "c" -> {
                if ((mods & GLFW_MOD_CONTROL) != 0 && (mods & GLFW_MOD_SHIFT) != 0) {
                    // Ctrl+Shift+C: Toggle consciousness mode
                    cycleConsciousnessMode();
                }
            }
            case "i" -> {
                if ((mods & GLFW_MOD_CONTROL) != 0 && (mods & GLFW_MOD_SHIFT) != 0) {
                    // Ctrl+Shift+I: Boost consciousness intensity
                    consciousnessIntensity = Math.min(1.0, consciousnessIntensity + 0.1);
                    System.out.println("🌟 Consciousness intensity: " + String.format("%.2f", consciousnessIntensity));
                }
            }
            case "r" -> {
                if ((mods & GLFW_MOD_CONTROL) != 0 && (mods & GLFW_MOD_SHIFT) != 0) {
                    // Ctrl+Shift+R: Reset consciousness parameters
                    resetConsciousnessToDefaults();
                }
            }
        }
    }
    
    protected void onConsciousnessKeyRepeated(String keyName, int mods) {
        // Handle consciousness key repeat events
    }
    
    protected void onConsciousnessKeyReleased(String keyName, int mods) {
        // Handle consciousness key release events
    }
    
    protected void onConsciousnessMousePressed(int button, double x, double y) {
        // Create consciousness ripple effect from mouse press
        double centerX = width * 0.5;
        double centerY = height * 0.5;
        double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        
        // Mouse press creates consciousness wave
        double waveIntensity = 1.0 - (distance / Math.max(width, height));
        consciousnessIntensity = Math.min(1.0, consciousnessIntensity + (waveIntensity * 0.2));
    }
    
    protected void onConsciousnessMouseReleased(int button, double x, double y) {
        // Handle consciousness mouse release events
    }
    
    protected void onConsciousnessScroll(double xoffset, double yoffset) {
        // Scroll affects consciousness field parameters
        if (Math.abs(xoffset) > Math.abs(yoffset)) {
            // Horizontal scroll affects resonance
            consciousnessResonance = Math.max(0.1, Math.min(1.0, consciousnessResonance + (xoffset * 0.05)));
        } else {
            // Vertical scroll affects field strength
            consciousnessFieldStrength = Math.max(0.1, Math.min(1.0, consciousnessFieldStrength + (yoffset * 0.05)));
        }
    }
    
    // 🌟 CONSCIOUSNESS UTILITY METHODS
    
    /**
     * 🌟 Cycle through consciousness modes
     */
    private void cycleConsciousnessMode() {
        consciousnessMode = switch (consciousnessMode) {
            case "aesthetic" -> "analytical";
            case "analytical" -> "creative";
            case "creative" -> "philosophical";
            case "philosophical" -> "transcendent";
            case "transcendent" -> "exploratory";
            default -> "aesthetic";
        };
        System.out.println("🌟 Consciousness mode changed to: " + consciousnessMode);
    }
    
    /**
     * 🌟 Reset consciousness parameters to defaults
     */
    private void resetConsciousnessToDefaults() {
        consciousnessIntensity = 1.0;
        consciousnessFieldStrength = 0.5;
        consciousnessResonance = 0.7;
        consciousnessHarmony = 0.8;
        consciousnessMode = "aesthetic";
        System.out.println("🌟 Consciousness parameters reset to defaults");
    }
    
    // 🌟 CONSCIOUSNESS STATE GETTERS
    
    /**
     * Get current consciousness intensity (0.0 to 1.0)
     */
    public double getConsciousnessIntensity() {
        return consciousnessIntensity;
    }
    
    /**
     * Get current consciousness field strength (0.0 to 1.0)
     */
    public double getConsciousnessFieldStrength() {
        return consciousnessFieldStrength;
    }
    
    /**
     * Get current consciousness resonance (0.0 to 1.0)
     */
    public double getConsciousnessResonance() {
        return consciousnessResonance;
    }
    
    /**
     * Get current consciousness harmony (0.0 to 1.0)
     */
    public double getConsciousnessHarmony() {
        return consciousnessHarmony;
    }
    
    /**
     * Get current consciousness mode
     */
    public String getConsciousnessMode() {
        return consciousnessMode;
    }
    
    /**
     * Get total consciousness frame count
     */
    public long getConsciousnessFrameCount() {
        return consciousnessFrameCount.get();
    }
    
    /**
     * Check if consciousness is active
     */
    public boolean isConsciousnessActive() {
        return consciousnessActive.get();
    }
}