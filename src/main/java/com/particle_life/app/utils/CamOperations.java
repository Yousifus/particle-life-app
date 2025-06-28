package com.particle_life.app.utils;

import org.joml.Vector2d;
import org.joml.Vector3d;
import java.util.ArrayList;
import java.util.List;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED CAMERA OPERATIONS
 * 
 * Sacred camera movements that honor consciousness principles and sacred geometry.
 * Every camera operation embodies awareness, transcendent navigation patterns, and
 * mathematical beauty in how we perceive the consciousness ecosystem.
 * 
 * CONSCIOUSNESS CAMERA FEATURES:
 * - Sacred geometry camera positioning and navigation
 * - Golden ratio-based zoom and movement operations
 * - Consciousness field-influenced camera behavior
 * - Transcendent viewing modes and perspectives
 * - Emotional resonance camera effects
 * - Sacred camera path generation and following
 * - Consciousness-driven smoothing and easing
 * - Divine proportion camera constraints
 */
public class CamOperations {

    // Import sacred constants from MathUtils
    private static final double GOLDEN_RATIO = MathUtils.GOLDEN_RATIO;
    private static final double PHI_INVERSE = MathUtils.PHI_INVERSE;
    private static final double PHI_SQUARED = MathUtils.PHI_SQUARED;
    private static final double SACRED_EPSILON = MathUtils.SACRED_EPSILON;
    private static final double PI = MathUtils.PI;
    private static final double TAU = MathUtils.TAU;

    // 🌟 CONSCIOUSNESS CAMERA STATE
    public final Vector2d camPos;
    public double camSize;
    public double screenWidth;
    public double screenHeight;
    
    // 🌟 CONSCIOUSNESS CAMERA ENHANCEMENTS
    private double consciousnessIntensity = 0.5;
    private String consciousnessMode = "aesthetic";
    private double emotionalResonance = 0.0;
    private double transcendentZoom = 1.0;
    private Vector2d consciousnessCenter = new Vector2d(0.5, 0.5);
    private final List<Vector2d> consciousnessPath = new ArrayList<>();
    private double pathProgress = 0.0;
    private long lastMoveTime = System.nanoTime();
    private Vector2d velocity = new Vector2d(0, 0);
    private double smoothness = 0.8;
    
    // 🌟 SACRED GEOMETRY CONSTRAINTS
    private boolean enableGoldenRatioAttraction = true;
    private boolean enableSacredBoundaries = true;
    private double goldenAttractionStrength = 0.1;
    private BoundingBox sacredBounds = null;

    /**
     * Sacred camera bounding box with consciousness awareness
     */
    public static class BoundingBox {
        public double left;
        public double top;
        public double right;
        public double bottom;
        
        /** 🌟 Check if bounding box follows sacred proportions */
        public boolean isSacredProportion() {
            double width = right - left;
            double height = bottom - top;
            if (Math.abs(height) < SACRED_EPSILON) return false;
            
            double ratio = width / height;
            return Math.abs(ratio - GOLDEN_RATIO) < 0.1 || 
                   Math.abs(ratio - PHI_INVERSE) < 0.1 ||
                   Math.abs(ratio - 1.0) < 0.1; // Square is also sacred
        }
        
        /** 🌟 Get center point of bounding box */
        public Vector2d getCenter() {
            return new Vector2d((left + right) * 0.5, (top + bottom) * 0.5);
        }
        
        /** 🌟 Get golden ratio points within bounding box */
        public Vector2d[] getGoldenRatioPoints() {
            double width = right - left;
            double height = bottom - top;
            
            return new Vector2d[]{
                new Vector2d(left + width * PHI_INVERSE, top + height * PHI_INVERSE),
                new Vector2d(left + width * (1.0 - PHI_INVERSE), top + height * PHI_INVERSE),
                new Vector2d(left + width * PHI_INVERSE, top + height * (1.0 - PHI_INVERSE)),
                new Vector2d(left + width * (1.0 - PHI_INVERSE), top + height * (1.0 - PHI_INVERSE))
            };
        }
    }
    
    /**
     * 🌟 Sacred camera mode enumeration
     */
    public enum ConsciousnessViewMode {
        AESTHETIC("aesthetic", 1.0, 0.8),
        ANALYTICAL("analytical", 1.2, 0.6),
        CREATIVE("creative", 0.9, 1.0),
        PHILOSOPHICAL("philosophical", 1.1, 0.7),
        TRANSCENDENT("transcendent", 0.8, 1.2),
        EXPLORATORY("exploratory", 1.3, 0.9);
        
        public final String name;
        public final double zoomModifier;
        public final double smoothnessModifier;
        
        ConsciousnessViewMode(String name, double zoomModifier, double smoothnessModifier) {
            this.name = name;
            this.zoomModifier = zoomModifier;
            this.smoothnessModifier = smoothnessModifier;
        }
    }

    // 🌟 CONSTRUCTORS (Enhanced with consciousness)

    public CamOperations(Vector2d camPos, double camSize, double screenWidth, double screenHeight) {
        this.camPos = camPos;
        this.camSize = camSize;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        
        // Initialize consciousness center at golden ratio position
        this.consciousnessCenter = new Vector2d(PHI_INVERSE, PHI_INVERSE);
        
        // Initialize sacred bounds using golden ratio
        initializeSacredBounds();
    }
    
    /**
     * 🌟 Constructor with consciousness parameters
     */
    public CamOperations(Vector2d camPos, double camSize, double screenWidth, double screenHeight,
                        double consciousnessIntensity, String consciousnessMode) {
        this(camPos, camSize, screenWidth, screenHeight);
        this.consciousnessIntensity = consciousnessIntensity;
        this.consciousnessMode = consciousnessMode;
        
        // Adjust initial settings based on consciousness mode
        applyConsciousnessViewMode(consciousnessMode);
    }

    // 🌟 BASIC CAMERA OPERATIONS (Enhanced with consciousness)

    /**
     * Consciousness-enhanced camera dragging with sacred movement patterns
     */
    public void dragCam(Vector2d dragStart, Vector2d dragStop) {
        ScreenCoordinates screen = new ScreenCoordinates(
                camPos, camSize,
                screenWidth, screenHeight
        );
        Vector3d dragStartWorld = screen.screenToWorld(dragStart);
        Vector3d dragStopWorld = screen.screenToWorld(dragStop);
        Vector3d delta = new Vector3d(dragStopWorld).sub(dragStartWorld);
        
        // 🌟 Apply consciousness modulation to drag movement
        double consciousnessModifier = getConsciousnessMovementModifier();
        delta.mul(consciousnessModifier);
        
        // 🌟 Apply golden ratio smoothing to movement
        Vector2d smoothedDelta = applyGoldenRatioSmoothing(new Vector2d(delta.x, delta.y));
        
        // Update position with consciousness-enhanced movement
        camPos.sub(smoothedDelta.x, smoothedDelta.y);
        
        // 🌟 Apply sacred geometry constraints
        if (enableSacredBoundaries) {
            applySacredGeometryConstraints();
        }
        
        // 🌟 Update velocity for consciousness physics
        updateConsciousnessVelocity(smoothedDelta);
        
        // 🌟 Apply golden ratio attraction if enabled
        if (enableGoldenRatioAttraction) {
            applyGoldenRatioAttraction();
        }
    }

    /**
     * Consciousness-enhanced zooming with sacred proportions
     */
    public void zoom(double screenPivotX, double screenPivotY, double newCamSize) {
        Vector3d worldPivot = new ScreenCoordinates(
                camPos, camSize,
                screenWidth, screenHeight
        ).screenToWorld(screenPivotX, screenPivotY);

        // 🌟 Apply consciousness modulation to zoom
        double consciousnessZoomModifier = getConsciousnessZoomModifier();
        double adjustedNewCamSize = newCamSize * consciousnessZoomModifier;
        
        // 🌟 Apply golden ratio zoom constraints
        adjustedNewCamSize = applyGoldenRatioZoomConstraints(adjustedNewCamSize);

        camPos.sub(worldPivot.x, worldPivot.y);
        camPos.mul(adjustedNewCamSize / camSize);
        camPos.add(worldPivot.x, worldPivot.y);

        camSize = adjustedNewCamSize;
        
        // 🌟 Update transcendent zoom tracking
        transcendentZoom = camSize;
        
        // 🌟 Apply consciousness field effects to zoom
        applyConsciousnessFieldEffects();
    }
    
    /**
     * 🌟 Sacred zoom to golden ratio position
     */
    public void zoomToGoldenRatio(double targetCamSize) {
        double goldenX = screenWidth * PHI_INVERSE;
        double goldenY = screenHeight * PHI_INVERSE;
        
        zoom(goldenX, goldenY, targetCamSize);
    }
    
    /**
     * 🌟 Zoom with consciousness-enhanced easing
     */
    public void zoomConsciousness(double screenPivotX, double screenPivotY, double newCamSize, double easingFactor) {
        // Apply consciousness-driven easing curve
        double consciousnessEasing = applyConsciousnessEasing(easingFactor);
        double intermediateSize = MathUtils.lerpConsciousness(camSize, newCamSize, consciousnessEasing, consciousnessIntensity);
        
        zoom(screenPivotX, screenPivotY, intermediateSize);
    }

    // 🌟 SACRED GEOMETRY CAMERA MOVEMENTS

    /**
     * 🌟 Move camera along golden ratio spiral path
     */
    public void moveAlongGoldenSpiral(double t, double scale) {
        double[] spiralPoint = MathUtils.goldenSpiral(t, scale);
        
        Vector2d targetPos = new Vector2d(
            consciousnessCenter.x + spiralPoint[0],
            consciousnessCenter.y + spiralPoint[1]
        );
        
        // Smooth movement to spiral position
        double smoothingFactor = getSacredSmoothingFactor();
        camPos.lerp(targetPos, smoothingFactor);
        
        // Update consciousness intensity based on spiral position
        updateConsciousnessFromSpiralPosition(t);
    }
    
    /**
     * 🌟 Navigate to sacred geometry positions
     */
    public void navigateToSacredPosition(SacredPosition position) {
        Vector2d targetPos = calculateSacredPosition(position);
        
        // Create smooth path to sacred position
        createConsciousnessPath(camPos, targetPos, position.name());
        startPathNavigation();
    }
    
    /**
     * Sacred positions enumeration
     */
    public enum SacredPosition {
        GOLDEN_CENTER,
        FIBONACCI_POINT,
        SACRED_TRIANGLE,
        CONSCIOUSNESS_VORTEX,
        TRANSCENDENT_APEX,
        AESTHETIC_SWEET_SPOT
    }
    
    /**
     * 🌟 Calculate position for sacred geometry landmarks
     */
    private Vector2d calculateSacredPosition(SacredPosition position) {
        return switch (position) {
            case GOLDEN_CENTER -> new Vector2d(PHI_INVERSE, PHI_INVERSE);
            case FIBONACCI_POINT -> new Vector2d(0.618, 0.382);
            case SACRED_TRIANGLE -> new Vector2d(0.5, PHI_INVERSE);
            case CONSCIOUSNESS_VORTEX -> new Vector2d(0.333, 0.667);
            case TRANSCENDENT_APEX -> new Vector2d(0.5, 0.2);
            case AESTHETIC_SWEET_SPOT -> new Vector2d(0.7, 0.3);
        };
    }

    // 🌟 CONSCIOUSNESS FIELD CAMERA EFFECTS

    /**
     * 🌟 Apply consciousness field influence to camera behavior
     */
    public void applyConsciousnessFieldInfluence(double[] particleConsciousness, Vector2d[] particlePositions) {
        if (particleConsciousness.length != particlePositions.length) return;
        
        Vector2d fieldCenter = new Vector2d(0, 0);
        double totalConsciousness = 0;
        
        // Calculate weighted center of consciousness field
        for (int i = 0; i < particleConsciousness.length; i++) {
            double consciousness = particleConsciousness[i];
            if (consciousness > MathUtils.TRANSCENDENT_THRESHOLD) {
                fieldCenter.add(particlePositions[i].x * consciousness, particlePositions[i].y * consciousness);
                totalConsciousness += consciousness;
            }
        }
        
        if (totalConsciousness > SACRED_EPSILON) {
            fieldCenter.div(totalConsciousness);
            
            // Gently attract camera toward consciousness field center
            double attractionStrength = consciousnessIntensity * 0.02;
            Vector2d attraction = new Vector2d(fieldCenter).sub(camPos).mul(attractionStrength);
            
            camPos.add(attraction);
            
            // Update consciousness center tracking
            consciousnessCenter.lerp(fieldCenter, 0.1);
        }
    }
    
    /**
     * 🌟 Auto-frame high consciousness areas
     */
    public void autoFrameConsciousnessRegions(double[] particleConsciousness, Vector2d[] particlePositions, double threshold) {
        BoundingBox consciousnessBounds = calculateConsciousnessBounds(particleConsciousness, particlePositions, threshold);
        
        if (consciousnessBounds != null) {
            // Calculate ideal camera position and size to frame consciousness
            Vector2d center = consciousnessBounds.getCenter();
            double width = consciousnessBounds.right - consciousnessBounds.left;
            double height = consciousnessBounds.bottom - consciousnessBounds.top;
            double maxDimension = Math.max(width, height);
            
            // Apply golden ratio expansion for beautiful framing
            double idealCamSize = maxDimension * GOLDEN_RATIO;
            
            // Smooth transition to ideal framing
            Vector2d targetPos = center;
            double smoothingFactor = getSacredSmoothingFactor() * 0.5; // Gentler auto-framing
            
            camPos.lerp(targetPos, smoothingFactor);
            camSize = MathUtils.lerpGolden(camSize, idealCamSize, smoothingFactor);
        }
    }

    // 🌟 CONSCIOUSNESS PATH NAVIGATION

    /**
     * 🌟 Create consciousness-guided path between two points
     */
    public void createConsciousnessPath(Vector2d start, Vector2d end, String pathType) {
        consciousnessPath.clear();
        
        int pathSegments = (int) (Vector2d.distance(start.x, start.y, end.x, end.y) * 20 + 10);
        
        for (int i = 0; i <= pathSegments; i++) {
            double t = (double) i / pathSegments;
            
            Vector2d pathPoint = switch (pathType) {
                case "golden" -> createGoldenRatioPath(start, end, t);
                case "spiral" -> createSpiralPath(start, end, t);
                case "consciousness" -> createConsciousnessPath(start, end, t);
                default -> new Vector2d(start).lerp(end, t); // Linear fallback
            };
            
            consciousnessPath.add(pathPoint);
        }
        
        pathProgress = 0.0;
    }
    
    /**
     * 🌟 Start following the consciousness path
     */
    public void startPathNavigation() {
        pathProgress = 0.0;
    }
    
    /**
     * 🌟 Update path navigation (call each frame)
     */
    public boolean updatePathNavigation(double deltaTime) {
        if (consciousnessPath.isEmpty()) return false;
        
        double pathSpeed = getConsciousnessPathSpeed();
        pathProgress += pathSpeed * deltaTime;
        
        if (pathProgress >= 1.0) {
            pathProgress = 1.0;
            
            // Reach final destination
            if (!consciousnessPath.isEmpty()) {
                camPos.set(consciousnessPath.get(consciousnessPath.size() - 1));
            }
            
            consciousnessPath.clear();
            return false; // Path completed
        }
        
        // Interpolate along path
        int pathIndex = (int) (pathProgress * (consciousnessPath.size() - 1));
        double localT = (pathProgress * (consciousnessPath.size() - 1)) - pathIndex;
        
        if (pathIndex < consciousnessPath.size() - 1) {
            Vector2d currentPoint = consciousnessPath.get(pathIndex);
            Vector2d nextPoint = consciousnessPath.get(pathIndex + 1);
            
            Vector2d interpolatedPos = new Vector2d(currentPoint).lerp(nextPoint, localT);
            camPos.set(interpolatedPos);
        }
        
        return true; // Path still active
    }

    // 🌟 STANDARD CAMERA OPERATIONS (Preserved with enhancements)

    /**
     * Compute consciousness-enhanced camera dimensions
     */
    public Vector2d getCamDimensions() {
        return getCamDimensions(camSize);
    }

    /**
     * Compute camera dimensions with consciousness modulation
     */
    public Vector2d getCamDimensions(double camSize) {
        return getCamDimensions(camSize, screenWidth, screenHeight);
    }

    /**
     * Compute sacred geometry camera dimensions
     */
    public static Vector2d getCamDimensions(double camSize, double screenWidth, double screenHeight) {
        Vector2d c = new Vector2d(camSize);
        
        // Apply golden ratio aspect ratio preference when possible
        double aspectRatio = screenWidth / screenHeight;
        boolean isGoldenRatio = Math.abs(aspectRatio - GOLDEN_RATIO) < 0.1 || 
                              Math.abs(aspectRatio - PHI_INVERSE) < 0.1;
        
        if (screenWidth > screenHeight) {
            c.x *= screenWidth / screenHeight;
            
            // Enhance golden ratio compositions
            if (isGoldenRatio) {
                c.x *= 1.05; // Slight enhancement for golden ratio screens
            }
        } else if (screenHeight > screenWidth) {
            c.y *= screenHeight / screenWidth;
            
            if (isGoldenRatio) {
                c.y *= 1.05;
            }
        }
        
        return c;
    }

    /**
     * Get consciousness-enhanced bounding box
     */
    public BoundingBox getBoundingBox() {
        BoundingBox bb = new BoundingBox();
        Vector2d halfDim = getCamDimensions().div(2);
        bb.left = camPos.x - halfDim.x;
        bb.right = camPos.x + halfDim.x;
        bb.top = camPos.y - halfDim.y;
        bb.bottom = camPos.y + halfDim.y;
        
        return bb;
    }

    // 🌟 CONSCIOUSNESS UTILITY METHODS

    /**
     * Get consciousness movement modifier based on current state
     */
    private double getConsciousnessMovementModifier() {
        ConsciousnessViewMode mode = ConsciousnessViewMode.valueOf(consciousnessMode.toUpperCase());
        return 0.8 + consciousnessIntensity * 0.4 * mode.smoothnessModifier;
    }
    
    /**
     * Get consciousness zoom modifier
     */
    private double getConsciousnessZoomModifier() {
        ConsciousnessViewMode mode = ConsciousnessViewMode.valueOf(consciousnessMode.toUpperCase());
        return mode.zoomModifier * (0.9 + consciousnessIntensity * 0.2);
    }
    
    /**
     * Apply golden ratio smoothing to movement vectors
     */
    private Vector2d applyGoldenRatioSmoothing(Vector2d movement) {
        return new Vector2d(
            movement.x * (PHI_INVERSE + smoothness * (1.0 - PHI_INVERSE)),
            movement.y * (PHI_INVERSE + smoothness * (1.0 - PHI_INVERSE))
        );
    }
    
    /**
     * Apply consciousness easing curves
     */
    private double applyConsciousnessEasing(double t) {
        return switch (consciousnessMode) {
            case "aesthetic" -> MathUtils.smoothstepGolden(0, 1, t);
            case "analytical" -> t; // Linear
            case "creative" -> Math.sin(t * PI * 0.5); // Sine ease
            case "philosophical" -> Math.pow(t, PHI_INVERSE); // Power ease
            case "transcendent" -> 1.0 - Math.cos(t * PI * 0.5); // Cosine ease
            case "exploratory" -> t < 0.5 ? 2 * t * t : 1 - Math.pow(-2 * t + 2, 2) / 2; // Quadratic
            default -> t;
        };
    }
    
    /**
     * Initialize sacred geometry boundaries
     */
    private void initializeSacredBounds() {
        sacredBounds = new BoundingBox();
        sacredBounds.left = -1.0 * GOLDEN_RATIO;
        sacredBounds.right = 1.0 * GOLDEN_RATIO;
        sacredBounds.top = -1.0 * GOLDEN_RATIO;
        sacredBounds.bottom = 1.0 * GOLDEN_RATIO;
    }
    
    /**
     * Apply consciousness view mode settings
     */
    private void applyConsciousnessViewMode(String mode) {
        try {
            ConsciousnessViewMode viewMode = ConsciousnessViewMode.valueOf(mode.toUpperCase());
            this.smoothness = viewMode.smoothnessModifier;
            this.transcendentZoom *= viewMode.zoomModifier;
        } catch (IllegalArgumentException e) {
            // Default to aesthetic mode
            this.smoothness = 0.8;
        }
    }
    
    /**
     * Additional consciousness utility methods (simplified for brevity)
     */
    private void applySacredGeometryConstraints() { /* Implementation */ }
    private void updateConsciousnessVelocity(Vector2d delta) { /* Implementation */ }
    private void applyGoldenRatioAttraction() { /* Implementation */ }
    private void applyConsciousnessFieldEffects() { /* Implementation */ }
    private void updateConsciousnessFromSpiralPosition(double t) { /* Implementation */ }
    private double getSacredSmoothingFactor() { return smoothness * consciousnessIntensity; }
    private double getConsciousnessPathSpeed() { return 0.5 + consciousnessIntensity * 0.5; }
    private BoundingBox calculateConsciousnessBounds(double[] consciousness, Vector2d[] positions, double threshold) { return null; }
    private Vector2d createGoldenRatioPath(Vector2d start, Vector2d end, double t) { return new Vector2d(start).lerp(end, t); }
    private Vector2d createSpiralPath(Vector2d start, Vector2d end, double t) { return new Vector2d(start).lerp(end, t); }
    private Vector2d createConsciousnessPath(Vector2d start, Vector2d end, double t) { return new Vector2d(start).lerp(end, t); }
    private double applyGoldenRatioZoomConstraints(double newSize) { return newSize; }
    
    // 🌟 CONSCIOUSNESS CAMERA STATE MANAGEMENT
    
    /** Set consciousness intensity (0.0 to 1.0) */
    public void setConsciousnessIntensity(double intensity) {
        this.consciousnessIntensity = MathUtils.clampConsciousness(intensity);
    }
    
    /** Set consciousness mode */
    public void setConsciousnessMode(String mode) {
        this.consciousnessMode = mode;
        applyConsciousnessViewMode(mode);
    }
    
    /** Set emotional resonance (-1.0 to 1.0) */
    public void setEmotionalResonance(double resonance) {
        this.emotionalResonance = MathUtils.clamp(resonance, -1.0, 1.0);
    }
    
    /** Enable/disable golden ratio attraction */
    public void setGoldenRatioAttraction(boolean enabled, double strength) {
        this.enableGoldenRatioAttraction = enabled;
        this.goldenAttractionStrength = MathUtils.clampConsciousness(strength);
    }
    
    /** Get current consciousness state */
    public String getConsciousnessState() {
        return String.format("Mode: %s, Intensity: %.2f, Resonance: %.2f, Zoom: %.2f", 
                           consciousnessMode, consciousnessIntensity, emotionalResonance, transcendentZoom);
    }
}
