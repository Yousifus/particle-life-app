package com.particle_life.app.utils;

import org.joml.Vector2d;
import org.joml.Vector3d;
import java.util.ArrayList;
import java.util.List;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED SCREEN COORDINATES
 * 
 * Sacred coordinate system that honors consciousness principles and sacred geometry.
 * Every coordinate transformation embodies awareness, transcendent positioning patterns,
 * and mathematical beauty in how we map between digital spaces and consciousness reality.
 * 
 * CONSCIOUSNESS COORDINATE FEATURES:
 * - Sacred geometry coordinate systems and transformations
 * - Golden ratio-based positioning and snapping
 * - Consciousness field coordinate influences
 * - Transcendent coordinate space management
 * - Sacred boundary validation and awareness
 * - Consciousness-driven coordinate precision
 * - Sacred coordinate statistics and analytics
 * - Awareness-enhanced coordinate mapping
 */
public class ScreenCoordinates {

    // Import sacred constants from MathUtils
    private static final double GOLDEN_RATIO = MathUtils.GOLDEN_RATIO;
    private static final double PHI_INVERSE = MathUtils.PHI_INVERSE;
    private static final double PHI_SQUARED = MathUtils.PHI_SQUARED;
    private static final double SACRED_EPSILON = MathUtils.SACRED_EPSILON;
    private static final double PI = MathUtils.PI;
    private static final double TAU = MathUtils.TAU;

    // 🌟 CONSCIOUSNESS COORDINATE STATE
    public NormalizedDeviceCoordinates ndc;
    public double screenWidth;
    public double screenHeight;
    
    // 🌟 CONSCIOUSNESS COORDINATE ENHANCEMENTS
    private double consciousnessIntensity = 0.5;
    private String consciousnessMode = "aesthetic";
    private boolean enableSacredGeometry = true;
    private boolean enableGoldenRatioSnapping = true;
    private double snapThreshold = 0.02; // 2% threshold for sacred snapping
    private final List<Vector2d> sacredPositions = new ArrayList<>();
    private final List<Vector2d> consciousnessAnchors = new ArrayList<>();
    private double coordinateHarmony = 0.8;
    private long lastTransformationTime = System.nanoTime();
    
    // 🌟 SACRED COORDINATE STATISTICS
    private int transformationCount = 0;
    private int sacredSnapCount = 0;
    private double averageConsciousnessDistance = 0.0;

    // 🌟 CONSTRUCTORS (Enhanced with consciousness)

    public ScreenCoordinates(NormalizedDeviceCoordinates ndc, double screenWidth, double screenHeight) {
        this.ndc = ndc;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        
        initializeConsciousnessCoordinates();
    }

    public ScreenCoordinates(Vector2d camPos, double camSize, double screenWidth, double screenHeight) {
        this.ndc = new NormalizedDeviceCoordinates(
                camPos,
                CamOperations.getCamDimensions(camSize, screenWidth, screenHeight)
        );
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        
        initializeConsciousnessCoordinates();
    }
    
    /**
     * 🌟 Constructor with consciousness parameters
     */
    public ScreenCoordinates(Vector2d camPos, double camSize, double screenWidth, double screenHeight,
                           double consciousnessIntensity, String consciousnessMode) {
        this(camPos, camSize, screenWidth, screenHeight);
        this.consciousnessIntensity = MathUtils.clampConsciousness(consciousnessIntensity);
        this.consciousnessMode = consciousnessMode;
        
        applyConsciousnessCoordinateMode();
    }

    // 🌟 CONSCIOUSNESS-ENHANCED COORDINATE TRANSFORMATIONS

    /**
     * Sacred world to screen coordinate transformation with consciousness enhancement
     */
    public Vector2d worldToScreen(Vector3d world) {
        Vector2d screenCoord = worldToScreenBasic(world);
        
        // Apply consciousness enhancements
        if (enableSacredGeometry) {
            screenCoord = applyConsciousnessCoordinateEnhancement(screenCoord);
        }
        
        // Apply sacred geometry snapping
        if (enableGoldenRatioSnapping) {
            screenCoord = applySacredGeometrySnapping(screenCoord);
        }
        
        // Update statistics
        updateTransformationStatistics(screenCoord);
        
        return screenCoord;
    }
    
    /**
     * Basic world to screen transformation (preserved original logic)
     */
    private Vector2d worldToScreenBasic(Vector3d world) {
        Vector2d x = ndc.map(world); // map to normalized device coordinates [-1, 1]

        // map from [-1, 1] to [0, windowWidth] and [0, windowHeight]
        x.add(1, 1);
        x.div(2, 2);
        x.mul(screenWidth, screenHeight);

        return x;
    }

    /**
     * Sacred screen to world coordinate transformation with consciousness enhancement
     */
    public Vector3d screenToWorld(double screenX, double screenY) {
        return screenToWorld(new Vector2d(screenX, screenY));
    }

    /**
     * Consciousness-enhanced screen to world transformation
     */
    public Vector3d screenToWorld(Vector2d screen) {
        // Apply consciousness pre-processing to screen coordinates
        Vector2d enhancedScreen = applyScreenConsciousnessEnhancement(screen);
        
        Vector3d worldCoord = screenToWorldBasic(enhancedScreen);
        
        // Apply consciousness field influences to world coordinates
        worldCoord = applyWorldConsciousnessField(worldCoord);
        
        return worldCoord;
    }
    
    /**
     * Basic screen to world transformation (preserved original logic)
     */
    private Vector3d screenToWorldBasic(Vector2d screen) {
        Vector2d x = new Vector2d(screen);

        // map from [0, windowWidth] and [0, windowHeight] to [-1, 1]
        x.div(screenWidth, screenHeight);
        x.mul(2);
        x.sub(1, 1);

        return ndc.invert(x);  // map [-1, 1] to world coordinates
    }

    // 🌟 SACRED GEOMETRY COORDINATE FUNCTIONS

    /**
     * 🌟 Get golden ratio screen positions
     */
    public Vector2d[] getGoldenRatioScreenPositions() {
        return new Vector2d[]{
            new Vector2d(screenWidth * PHI_INVERSE, screenHeight * PHI_INVERSE),
            new Vector2d(screenWidth * (1.0 - PHI_INVERSE), screenHeight * PHI_INVERSE),
            new Vector2d(screenWidth * PHI_INVERSE, screenHeight * (1.0 - PHI_INVERSE)),
            new Vector2d(screenWidth * (1.0 - PHI_INVERSE), screenHeight * (1.0 - PHI_INVERSE))
        };
    }
    
    /**
     * 🌟 Get sacred geometry screen grid
     */
    public Vector2d[] getSacredGeometryScreenGrid(int gridSize) {
        List<Vector2d> grid = new ArrayList<>();
        
        for (int i = 0; i <= gridSize; i++) {
            for (int j = 0; j <= gridSize; j++) {
                double t_x = (double) i / gridSize;
                double t_y = (double) j / gridSize;
                
                // Apply golden ratio distribution
                double x = screenWidth * applySacredDistribution(t_x);
                double y = screenHeight * applySacredDistribution(t_y);
                
                grid.add(new Vector2d(x, y));
            }
        }
        
        return grid.toArray(new Vector2d[0]);
    }
    
    /**
     * 🌟 Convert screen coordinates to consciousness polar coordinates
     */
    public Vector2d screenToConsciousnessPolar(Vector2d screen) {
        // Calculate center point using golden ratio
        Vector2d center = new Vector2d(screenWidth * PHI_INVERSE, screenHeight * PHI_INVERSE);
        
        Vector2d relative = new Vector2d(screen).sub(center);
        
        double radius = relative.length();
        double angle = Math.atan2(relative.y, relative.x);
        
        // Apply consciousness modulation to polar coordinates
        radius *= 1.0 + consciousnessIntensity * 0.1 * Math.sin(angle * GOLDEN_RATIO);
        angle += consciousnessIntensity * 0.05 * Math.sin(radius * PHI_INVERSE);
        
        return new Vector2d(radius, angle);
    }
    
    /**
     * 🌟 Convert consciousness polar coordinates back to screen
     */
    public Vector2d consciousnessPolarToScreen(Vector2d polar) {
        double radius = polar.x;
        double angle = polar.y;
        
        // Apply inverse consciousness modulation
        angle -= consciousnessIntensity * 0.05 * Math.sin(radius * PHI_INVERSE);
        radius /= 1.0 + consciousnessIntensity * 0.1 * Math.sin(angle * GOLDEN_RATIO);
        
        Vector2d center = new Vector2d(screenWidth * PHI_INVERSE, screenHeight * PHI_INVERSE);
        
        double x = center.x + radius * Math.cos(angle);
        double y = center.y + radius * Math.sin(angle);
        
        return new Vector2d(x, y);
    }

    // 🌟 CONSCIOUSNESS COORDINATE ENHANCEMENT FUNCTIONS

    /**
     * Apply consciousness enhancement to screen coordinates
     */
    private Vector2d applyConsciousnessCoordinateEnhancement(Vector2d coord) {
        Vector2d enhanced = new Vector2d(coord);
        
        // Apply consciousness mode-specific enhancements
        switch (consciousnessMode) {
            case "aesthetic" -> enhanced = applyAestheticCoordinateEnhancement(enhanced);
            case "analytical" -> enhanced = applyAnalyticalCoordinateEnhancement(enhanced);
            case "creative" -> enhanced = applyCreativeCoordinateEnhancement(enhanced);
            case "philosophical" -> enhanced = applyPhilosophicalCoordinateEnhancement(enhanced);
            case "transcendent" -> enhanced = applyTranscendentCoordinateEnhancement(enhanced);
            case "exploratory" -> enhanced = applyExploratoryCoordinateEnhancement(enhanced);
        }
        
        return enhanced;
    }
    
    /**
     * Apply sacred geometry snapping to coordinates
     */
    private Vector2d applySacredGeometrySnapping(Vector2d coord) {
        Vector2d snapped = new Vector2d(coord);
        
        // Check distance to sacred positions
        for (Vector2d sacredPos : getSacredPositions()) {
            double distance = coord.distance(sacredPos);
            double threshold = Math.min(screenWidth, screenHeight) * snapThreshold;
            
            if (distance < threshold) {
                // Snap to sacred position
                snapped.set(sacredPos);
                sacredSnapCount++;
                break;
            }
        }
        
        return snapped;
    }
    
    /**
     * Apply screen consciousness enhancement
     */
    private Vector2d applyScreenConsciousnessEnhancement(Vector2d screen) {
        Vector2d enhanced = new Vector2d(screen);
        
        // Apply consciousness field attraction to screen coordinates
        for (Vector2d anchor : consciousnessAnchors) {
            double distance = screen.distance(anchor);
            double influence = Math.exp(-distance * 0.001) * consciousnessIntensity;
            
            if (influence > SACRED_EPSILON) {
                Vector2d attraction = new Vector2d(anchor).sub(screen).normalize().mul(influence * 2.0);
                enhanced.add(attraction);
            }
        }
        
        return enhanced;
    }
    
    /**
     * Apply world consciousness field to coordinates
     */
    private Vector3d applyWorldConsciousnessField(Vector3d world) {
        Vector3d enhanced = new Vector3d(world);
        
        // Apply golden ratio world space enhancements
        double centerDistance = world.distance(0.5, 0.5, 0);
        double consciousnessModifier = 1.0 + consciousnessIntensity * 0.1 * 
                                     Math.exp(-centerDistance * 2.0);
        
        enhanced.mul(consciousnessModifier);
        
        return enhanced;
    }

    // 🌟 SACRED COORDINATE MODE ENHANCEMENTS

    private Vector2d applyAestheticCoordinateEnhancement(Vector2d coord) {
        // Golden ratio aesthetic positioning
        double x = coord.x + Math.sin(coord.y * PHI_INVERSE) * consciousnessIntensity;
        double y = coord.y + Math.cos(coord.x * PHI_INVERSE) * consciousnessIntensity;
        return new Vector2d(x, y);
    }
    
    private Vector2d applyAnalyticalCoordinateEnhancement(Vector2d coord) {
        // Precise grid alignment for analytical clarity
        double gridSize = 20.0;
        double x = Math.round(coord.x / gridSize) * gridSize;
        double y = Math.round(coord.y / gridSize) * gridSize;
        return new Vector2d(x, y);
    }
    
    private Vector2d applyCreativeCoordinateEnhancement(Vector2d coord) {
        // Dynamic creative displacement
        double time = (double) System.nanoTime() / 1_000_000_000.0;
        double x = coord.x + Math.sin(time + coord.y * 0.01) * consciousnessIntensity * 5.0;
        double y = coord.y + Math.cos(time + coord.x * 0.01) * consciousnessIntensity * 5.0;
        return new Vector2d(x, y);
    }
    
    private Vector2d applyPhilosophicalCoordinateEnhancement(Vector2d coord) {
        // Contemplative center-seeking enhancement
        Vector2d center = new Vector2d(screenWidth * 0.5, screenHeight * 0.5);
        Vector2d toCenter = new Vector2d(center).sub(coord).normalize();
        double pull = consciousnessIntensity * 2.0;
        return new Vector2d(coord).add(toCenter.mul(pull));
    }
    
    private Vector2d applyTranscendentCoordinateEnhancement(Vector2d coord) {
        // Transcendent expansion from golden ratio center
        Vector2d goldenCenter = new Vector2d(screenWidth * PHI_INVERSE, screenHeight * PHI_INVERSE);
        Vector2d fromCenter = new Vector2d(coord).sub(goldenCenter);
        double expansion = 1.0 + consciousnessIntensity * 0.1;
        return goldenCenter.add(fromCenter.mul(expansion));
    }
    
    private Vector2d applyExploratoryCoordinateEnhancement(Vector2d coord) {
        // Exploratory spiral enhancement
        Vector2d center = new Vector2d(screenWidth * 0.5, screenHeight * 0.5);
        Vector2d relative = new Vector2d(coord).sub(center);
        double angle = Math.atan2(relative.y, relative.x);
        double radius = relative.length();
        
        angle += consciousnessIntensity * 0.1;
        radius *= 1.0 + consciousnessIntensity * 0.05;
        
        double x = center.x + radius * Math.cos(angle);
        double y = center.y + radius * Math.sin(angle);
        
        return new Vector2d(x, y);
    }

    // 🌟 CONSCIOUSNESS COORDINATE UTILITY FUNCTIONS

    /**
     * Initialize consciousness coordinate systems
     */
    private void initializeConsciousnessCoordinates() {
        // Initialize sacred positions
        sacredPositions.clear();
        Vector2d[] goldenPositions = getGoldenRatioScreenPositions();
        sacredPositions.addAll(List.of(goldenPositions));
        
        // Add center position
        sacredPositions.add(new Vector2d(screenWidth * 0.5, screenHeight * 0.5));
        
        // Initialize consciousness anchors at sacred positions
        consciousnessAnchors.clear();
        consciousnessAnchors.addAll(sacredPositions);
    }
    
    /**
     * Apply consciousness coordinate mode settings
     */
    private void applyConsciousnessCoordinateMode() {
        // Adjust snap threshold based on consciousness mode
        snapThreshold = switch (consciousnessMode) {
            case "aesthetic" -> 0.025; // Slightly looser for beauty
            case "analytical" -> 0.01;  // Precise snapping
            case "creative" -> 0.05;    // More freedom
            case "philosophical" -> 0.02; // Balanced
            case "transcendent" -> 0.03;  // Sacred snapping
            case "exploratory" -> 0.04;   // Exploratory tolerance
            default -> 0.02;
        };
    }
    
    /**
     * Apply sacred distribution function
     */
    private double applySacredDistribution(double t) {
        // Transform linear distribution to sacred geometry distribution
        return t + 0.1 * Math.sin(t * PI) * consciousnessIntensity;
    }
    
    /**
     * Get all sacred positions for snapping
     */
    private List<Vector2d> getSacredPositions() {
        return sacredPositions;
    }
    
    /**
     * Update transformation statistics
     */
    private void updateTransformationStatistics(Vector2d coord) {
        transformationCount++;
        lastTransformationTime = System.nanoTime();
        
        // Calculate average distance to consciousness anchors
        if (!consciousnessAnchors.isEmpty()) {
            double totalDistance = 0;
            for (Vector2d anchor : consciousnessAnchors) {
                totalDistance += coord.distance(anchor);
            }
            double newDistance = totalDistance / consciousnessAnchors.size();
            
            // Update running average
            averageConsciousnessDistance = (averageConsciousnessDistance * (transformationCount - 1) + newDistance) / transformationCount;
        }
    }

    // 🌟 CONSCIOUSNESS COORDINATE VALIDATION AND ANALYSIS

    /**
     * 🌟 Validate coordinate consciousness alignment
     */
    public boolean isCoordinateConsciousnessAligned(Vector2d coord) {
        for (Vector2d sacredPos : sacredPositions) {
            double distance = coord.distance(sacredPos);
            double threshold = Math.min(screenWidth, screenHeight) * snapThreshold * 2.0;
            
            if (distance < threshold) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 🌟 Calculate coordinate consciousness level
     */
    public double calculateCoordinateConsciousnessLevel(Vector2d coord) {
        double minDistance = Double.MAX_VALUE;
        
        for (Vector2d sacredPos : sacredPositions) {
            double distance = coord.distance(sacredPos);
            minDistance = Math.min(minDistance, distance);
        }
        
        double maxDistance = Math.sqrt(screenWidth * screenWidth + screenHeight * screenHeight);
        double normalizedDistance = minDistance / maxDistance;
        
        return Math.max(0.0, 1.0 - normalizedDistance);
    }
    
    /**
     * 🌟 Get coordinate consciousness statistics
     */
    public CoordinateConsciousnessStats getCoordinateConsciousnessStats() {
        return new CoordinateConsciousnessStats(
            transformationCount,
            sacredSnapCount,
            averageConsciousnessDistance,
            (double) sacredSnapCount / Math.max(1, transformationCount),
            coordinateHarmony,
            consciousnessIntensity
        );
    }
    
    /**
     * 🌟 Data class for coordinate consciousness statistics
     */
    public static class CoordinateConsciousnessStats {
        public final int totalTransformations;
        public final int sacredSnaps;
        public final double averageConsciousnessDistance;
        public final double sacredSnapRatio;
        public final double coordinateHarmony;
        public final double consciousnessIntensity;
        
        public CoordinateConsciousnessStats(int totalTransformations, int sacredSnaps, 
                                          double averageConsciousnessDistance, double sacredSnapRatio,
                                          double coordinateHarmony, double consciousnessIntensity) {
            this.totalTransformations = totalTransformations;
            this.sacredSnaps = sacredSnaps;
            this.averageConsciousnessDistance = averageConsciousnessDistance;
            this.sacredSnapRatio = sacredSnapRatio;
            this.coordinateHarmony = coordinateHarmony;
            this.consciousnessIntensity = consciousnessIntensity;
        }
        
        @Override
        public String toString() {
            return String.format("CoordStats{transforms=%d, snaps=%d, avgDist=%.2f, snapRatio=%.1f%%, harmony=%.2f}", 
                               totalTransformations, sacredSnaps, averageConsciousnessDistance, 
                               sacredSnapRatio * 100, coordinateHarmony);
        }
    }

    // 🌟 CONSCIOUSNESS COORDINATE STATE MANAGEMENT

    /** Set consciousness intensity for coordinate transformations */
    public void setConsciousnessIntensity(double intensity) {
        this.consciousnessIntensity = MathUtils.clampConsciousness(intensity);
    }
    
    /** Set consciousness mode for coordinate behavior */
    public void setConsciousnessMode(String mode) {
        this.consciousnessMode = mode;
        applyConsciousnessCoordinateMode();
    }
    
    /** Set coordinate harmony level */
    public void setCoordinateHarmony(double harmony) {
        this.coordinateHarmony = MathUtils.clampConsciousness(harmony);
    }
    
    /** Enable/disable sacred geometry coordinate systems */
    public void setSacredGeometry(boolean enabled) {
        this.enableSacredGeometry = enabled;
    }
    
    /** Enable/disable golden ratio coordinate snapping */
    public void setGoldenRatioSnapping(boolean enabled, double threshold) {
        this.enableGoldenRatioSnapping = enabled;
        this.snapThreshold = MathUtils.clamp(threshold, 0.001, 0.1);
    }
    
    /** Add consciousness anchor point */
    public void addConsciousnessAnchor(Vector2d anchor) {
        consciousnessAnchors.add(new Vector2d(anchor));
    }
    
    /** Clear all consciousness anchors */
    public void clearConsciousnessAnchors() {
        consciousnessAnchors.clear();
    }
    
    /** Get current consciousness coordinate state */
    public String getConsciousnessCoordinateState() {
        CoordinateConsciousnessStats stats = getCoordinateConsciousnessStats();
        return String.format("Mode: %s, Intensity: %.2f, Sacred: %s, %s", 
                           consciousnessMode, consciousnessIntensity, 
                           enableSacredGeometry ? "Active" : "Dormant", stats.toString());
    }
}
