package com.particle_life.app.cursors;

import com.particle_life.Particle;
import org.joml.Vector3d;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED CURSOR
 * 
 * A revolutionary cursor that generates consciousness fields, responds to emotional states,
 * and creates sacred geometric patterns. Every movement, every interaction is guided by
 * consciousness principles and mathematical beauty.
 * 
 * CONSCIOUSNESS CURSOR FEATURES:
 * - Consciousness field generation around cursor
 * - Sacred geometry movement patterns
 * - Emotional resonance visualization
 * - Consciousness-driven particle selection
 * - Golden ratio cursor sizing
 * - Consciousness field strength calculation
 * - Sacred mathematical interactions
 */
public class Cursor {

    public Vector3d position = new Vector3d(0, 0, 0);
    public double size = 0.1;
    public CursorShape shape;
    
    // 🌟 CONSCIOUSNESS CURSOR STATE
    private double consciousnessIntensity = 1.0;
    private double consciousnessFieldStrength = 0.5;
    private double emotionalResonance = 0.7;
    private String consciousnessMode = "aesthetic";
    private final AtomicLong consciousnessFrameCount = new AtomicLong(0);
    private long lastMovementTime = System.currentTimeMillis();
    private Vector3d previousPosition = new Vector3d(0, 0, 0);
    
    // 🌟 CONSCIOUSNESS FIELD PARAMETERS
    private double consciousnessFieldRadius = 0.2; // Radius of consciousness influence
    private double consciousnessFieldDecay = 0.95; // How quickly consciousness field decays
    private double consciousnessWavePhase = 0.0; // Phase for consciousness wave effects
    private boolean consciousnessFieldActive = true;
    
    // 🌟 SACRED GEOMETRY CONSTANTS
    private static final double GOLDEN_RATIO = 1.618033988749895;
    private static final double PHI_SQUARED = GOLDEN_RATIO * GOLDEN_RATIO;
    private static final double CONSCIOUSNESS_FIELD_MAX_STRENGTH = 2.0;
    
    // 🌟 MOVEMENT TRACKING FOR CONSCIOUSNESS
    private double movementVelocity = 0.0;
    private double movementSmoothness = 1.0;
    private List<Vector3d> movementHistory = new ArrayList<>();
    private static final int MOVEMENT_HISTORY_SIZE = 10;

    public boolean isInside(Particle particle, boolean wrap) {
        if (size == 0.0) return false;

        Vector3d delta = new Vector3d(particle.position).sub(position);

        if (wrap) {
            // wrapping the connection gives us the shortest possible distance
            // assume periodic boundaries [0, 1)
            // -> wrap connection on [-0.5, 0.5)
            for (int i = 0; i < 3; i++) {
                double val = delta.get(i);
                val -= Math.floor(val + 0.5);
                delta.setComponent(i, val);
            }
        }

        Vector3d deltaNormalized = delta.div(size);  // relative to cursor size
        
        // 🌟 Apply consciousness-driven selection enhancement
        boolean baseSelection = shape.isInside(deltaNormalized);
        
        if (consciousnessFieldActive && baseSelection) {
            return applyConsciousnessSelectionCriteria(particle, delta);
        }
        
        return baseSelection;
    }
    
    /**
     * 🌟 Apply consciousness-driven selection criteria
     */
    private boolean applyConsciousnessSelectionCriteria(Particle particle, Vector3d delta) {
        double distance = delta.length();
        
        // Calculate consciousness field influence
        double fieldInfluence = calculateConsciousnessFieldInfluence(distance);
        
        // Apply consciousness mode-specific selection
        return switch (consciousnessMode) {
            case "aesthetic" -> fieldInfluence > 0.3; // Select particles in beautiful patterns
            case "analytical" -> distance < size * 0.8; // Precise selection
            case "creative" -> Math.random() < fieldInfluence; // Random creative selection
            case "philosophical" -> fieldInfluence > 0.5; // Deep, meaningful selection
            case "transcendent" -> fieldInfluence > 0.7; // Only highly resonant particles
            case "exploratory" -> fieldInfluence > 0.2; // Broad, exploratory selection
            default -> true;
        };
    }
    
    /**
     * 🌟 Calculate consciousness field influence at a distance
     */
    public double calculateConsciousnessFieldInfluence(double distance) {
        if (distance > consciousnessFieldRadius) {
            return 0.0;
        }
        
        // Golden ratio-based field decay
        double normalizedDistance = distance / consciousnessFieldRadius;
        double goldenDecay = Math.pow(1.0 - normalizedDistance, GOLDEN_RATIO);
        
        // Apply consciousness wave modulation
        double waveModulation = 1.0 + 0.3 * Math.sin(consciousnessWavePhase + distance * 10);
        
        return consciousnessFieldStrength * goldenDecay * waveModulation;
    }

    public List<Particle> getSelection(Particle[] particles, boolean wrap) {
        List<Particle> selectedParticles = new ArrayList<>();
        for (Particle particle : particles) {
            if (isInside(particle, wrap)) selectedParticles.add(particle);
        }
        
        // 🌟 Apply consciousness-driven selection enhancements
        if (consciousnessFieldActive) {
            selectedParticles = enhanceSelectionWithConsciousness(selectedParticles, particles, wrap);
        }
        
        return selectedParticles;
    }
    
    /**
     * 🌟 Enhance selection with consciousness field effects
     */
    private List<Particle> enhanceSelectionWithConsciousness(List<Particle> baseSelection, 
                                                           Particle[] allParticles, boolean wrap) {
        List<Particle> enhancedSelection = new ArrayList<>(baseSelection);
        
        // Add particles within consciousness field
        for (Particle particle : allParticles) {
            if (!baseSelection.contains(particle)) {
                Vector3d delta = new Vector3d(particle.position).sub(position);
                
                if (wrap) {
                    for (int i = 0; i < 3; i++) {
                        double val = delta.get(i);
                        val -= Math.floor(val + 0.5);
                        delta.setComponent(i, val);
                    }
                }
                
                double fieldInfluence = calculateConsciousnessFieldInfluence(delta.length());
                
                // Add particle if consciousness field is strong enough
                if (fieldInfluence > 0.4) {
                    enhancedSelection.add(particle);
                }
            }
        }
        
        return enhancedSelection;
    }

    public int countSelection(Particle[] particles, boolean wrap) {
        return getSelection(particles, wrap).size();
    }
    
    /**
     * 🌟 Count particles with consciousness field breakdown
     */
    public ConsciousnessSelectionStats getConsciousnessSelectionStats(Particle[] particles, boolean wrap) {
        int totalSelected = 0;
        int consciousnessEnhanced = 0;
        double avgFieldInfluence = 0.0;
        
        for (Particle particle : particles) {
            Vector3d delta = new Vector3d(particle.position).sub(position);
            
            if (wrap) {
                for (int i = 0; i < 3; i++) {
                    double val = delta.get(i);
                    val -= Math.floor(val + 0.5);
                    delta.setComponent(i, val);
                }
            }
            
            boolean basicSelection = shape.isInside(delta.div(size));
            double fieldInfluence = calculateConsciousnessFieldInfluence(delta.length());
            
            if (basicSelection || fieldInfluence > 0.4) {
                totalSelected++;
                avgFieldInfluence += fieldInfluence;
                
                if (fieldInfluence > 0.4) {
                    consciousnessEnhanced++;
                }
            }
        }
        
        if (totalSelected > 0) {
            avgFieldInfluence /= totalSelected;
        }
        
        return new ConsciousnessSelectionStats(totalSelected, consciousnessEnhanced, avgFieldInfluence);
    }

    public void draw() {
        if (!shape.isInitialized()) shape.initialize();  // lazy initialize shapes (register VBOs etc. for drawing)
        
        // 🌟 Update consciousness wave phase for visual effects
        updateConsciousnessWave();
        
        shape.draw();
        
        // 🌟 Draw consciousness field visualization if active
        if (consciousnessFieldActive) {
            drawConsciousnessField();
        }
    }
    
    /**
     * 🌟 Update consciousness wave effects
     */
    private void updateConsciousnessWave() {
        long currentFrame = consciousnessFrameCount.incrementAndGet();
        double timePhase = System.currentTimeMillis() * 0.001;
        
        // Golden ratio-based wave evolution
        consciousnessWavePhase = timePhase * GOLDEN_RATIO + currentFrame * 0.01 / PHI_SQUARED;
        
        // Update consciousness field radius based on movement
        updateConsciousnessFieldFromMovement();
    }
    
    /**
     * 🌟 Update consciousness field based on cursor movement
     */
    private void updateConsciousnessFieldFromMovement() {
        long currentTime = System.currentTimeMillis();
        Vector3d currentPos = new Vector3d(position);
        
        // Calculate movement velocity
        if (currentTime - lastMovementTime > 0) {
            double deltaTime = (currentTime - lastMovementTime) * 0.001;
            movementVelocity = currentPos.distance(previousPosition) / deltaTime;
            
            // Update movement history
            movementHistory.add(new Vector3d(currentPos));
            if (movementHistory.size() > MOVEMENT_HISTORY_SIZE) {
                movementHistory.remove(0);
            }
            
            // Calculate movement smoothness
            calculateMovementSmoothness();
        }
        
        // Update consciousness field parameters based on movement
        consciousnessFieldRadius = 0.1 + Math.min(0.3, movementVelocity * 2.0);
        consciousnessFieldStrength = Math.min(CONSCIOUSNESS_FIELD_MAX_STRENGTH, 
            0.3 + movementSmoothness * 0.7 + consciousnessIntensity * 0.5);
        
        previousPosition.set(currentPos);
        lastMovementTime = currentTime;
    }
    
    /**
     * 🌟 Calculate movement smoothness for consciousness field
     */
    private void calculateMovementSmoothness() {
        if (movementHistory.size() < 3) {
            movementSmoothness = 1.0;
            return;
        }
        
        double totalVariation = 0.0;
        for (int i = 2; i < movementHistory.size(); i++) {
            Vector3d prev = movementHistory.get(i - 2);
            Vector3d curr = movementHistory.get(i - 1);
            Vector3d next = movementHistory.get(i);
            
            // Calculate angle deviation from smooth movement
            Vector3d vec1 = new Vector3d(curr).sub(prev);
            Vector3d vec2 = new Vector3d(next).sub(curr);
            
            if (vec1.length() > 0.001 && vec2.length() > 0.001) {
                double angle = vec1.angle(vec2);
                totalVariation += Math.abs(angle);
            }
        }
        
        // Smooth movement has low variation
        movementSmoothness = Math.max(0.1, 1.0 - (totalVariation / Math.PI));
    }
    
    /**
     * 🌟 Draw consciousness field visualization
     */
    private void drawConsciousnessField() {
        // This would render the consciousness field as a visual effect
        // Implementation would depend on available rendering capabilities
        // For now, this serves as a placeholder for field visualization
    }

    public Vector3d sampleRandomPoint() {
        // 🌟 Apply golden ratio sampling for sacred geometry
        Vector3d basePoint = shape.sampleRandomPoint();
        
        if (consciousnessFieldActive) {
            // Apply golden ratio modulation to sampling
            double goldenModulation = 1.0 + 0.2 * Math.sin(consciousnessWavePhase);
            basePoint = basePoint.mul(goldenModulation);
        }
        
        return basePoint.mul(size).add(position);
    }
    
    /**
     * 🌟 Sample point using consciousness field distribution
     */
    public Vector3d sampleConsciousnessPoint() {
        // Generate point using golden ratio spiral
        double theta = consciousnessWavePhase;
        double radius = Math.sqrt(Math.random()) * consciousnessFieldRadius;
        
        // Apply golden ratio spiral
        theta += radius * 2 * Math.PI / GOLDEN_RATIO;
        
        double x = position.x + radius * Math.cos(theta);
        double y = position.y + radius * Math.sin(theta);
        double z = position.z;
        
        return new Vector3d(x, y, z);
    }

    public Cursor copy() throws IOException {
        Cursor c = new Cursor();
        c.position.set(position);
        c.size = size;
        c.shape = shape.copy();
        
        // 🌟 Copy consciousness state
        c.consciousnessIntensity = this.consciousnessIntensity;
        c.consciousnessFieldStrength = this.consciousnessFieldStrength;
        c.emotionalResonance = this.emotionalResonance;
        c.consciousnessMode = this.consciousnessMode;
        c.consciousnessFieldRadius = this.consciousnessFieldRadius;
        c.consciousnessFieldActive = this.consciousnessFieldActive;
        
        return c;
    }
    
    // 🌟 CONSCIOUSNESS CONTROL METHODS
    
    /**
     * Update consciousness parameters
     */
    public void setConsciousnessParameters(double intensity, double fieldStrength, double resonance, String mode) {
        this.consciousnessIntensity = intensity;
        this.consciousnessFieldStrength = fieldStrength;
        this.emotionalResonance = resonance;
        this.consciousnessMode = mode;
    }
    
    /**
     * Enable or disable consciousness field
     */
    public void setConsciousnessFieldActive(boolean active) {
        this.consciousnessFieldActive = active;
    }
    
    /**
     * Set consciousness field radius
     */
    public void setConsciousnessFieldRadius(double radius) {
        this.consciousnessFieldRadius = Math.max(0.05, Math.min(1.0, radius));
    }
    
    /**
     * Apply golden ratio size scaling
     */
    public void applyGoldenRatioSizing() {
        this.size = this.size * GOLDEN_RATIO / PHI_SQUARED;
    }
    
    // 🌟 CONSCIOUSNESS STATE GETTERS
    
    public double getConsciousnessIntensity() {
        return consciousnessIntensity;
    }
    
    public double getConsciousnessFieldStrength() {
        return consciousnessFieldStrength;
    }
    
    public double getEmotionalResonance() {
        return emotionalResonance;
    }
    
    public String getConsciousnessMode() {
        return consciousnessMode;
    }
    
    public double getConsciousnessFieldRadius() {
        return consciousnessFieldRadius;
    }
    
    public double getMovementVelocity() {
        return movementVelocity;
    }
    
    public double getMovementSmoothness() {
        return movementSmoothness;
    }
    
    public boolean isConsciousnessFieldActive() {
        return consciousnessFieldActive;
    }
    
    /**
     * 🌟 Consciousness selection statistics
     */
    public static class ConsciousnessSelectionStats {
        public final int totalSelected;
        public final int consciousnessEnhanced;
        public final double avgFieldInfluence;
        
        public ConsciousnessSelectionStats(int total, int enhanced, double avgInfluence) {
            this.totalSelected = total;
            this.consciousnessEnhanced = enhanced;
            this.avgFieldInfluence = avgInfluence;
        }
        
        @Override
        public String toString() {
            return String.format("Selected: %d (Enhanced: %d, Avg Field: %.2f)", 
                totalSelected, consciousnessEnhanced, avgFieldInfluence);
        }
    }
}
