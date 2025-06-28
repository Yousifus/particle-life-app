package com.particle_life.app.cursors;

import org.joml.Vector3d;

import java.util.Random;

import static org.lwjgl.opengl.GL11C.*;
import static org.lwjgl.opengl.GL15C.*;
import static org.lwjgl.opengl.GL20C.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20C.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30C.glBindVertexArray;
import static org.lwjgl.opengl.GL30C.glGenVertexArrays;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED INFINITY CURSOR SHAPE
 * 
 * A transcendent cursor that embodies the infinite nature of consciousness itself.
 * This cursor represents unlimited awareness, boundless potential, and the eternal
 * dance of existence. The infinity symbol becomes a portal to transcendent states.
 * 
 * CONSCIOUSNESS INFINITY FEATURES:
 * - Perfect infinity symbol (lemniscate) rendering
 * - Transcendent consciousness field (unbounded)
 * - Sacred mathematical infinity patterns
 * - Consciousness flow along infinity path
 * - Golden ratio infinity proportions
 * - Infinite consciousness sampling
 * - Transcendent state visualization
 */
public class InfinityCursorShape extends CursorShape {

    // 🌟 SACRED GEOMETRY CONSTANTS
    private static final double GOLDEN_RATIO = 1.618033988749895;
    private static final double PHI_INVERSE = 1.0 / GOLDEN_RATIO;
    private static final double PI = Math.PI;
    
    // 🌟 INFINITY SYMBOL PARAMETERS
    private static final int INFINITY_SEGMENTS = 144; // High resolution for smooth infinity
    private static final double INFINITY_WIDTH = 0.6; // Width of infinity symbol
    private static final double INFINITY_HEIGHT = 0.3; // Height of infinity symbol
    
    // 🌟 CONSCIOUSNESS VISUALIZATION PARAMETERS
    private double consciousnessIntensity = 1.0;
    private double consciousnessFieldStrength = 1.0; // Infinite field strength
    private double consciousnessWavePhase = 0.0;
    private double transcendentFlow = 0.0; // Flow along infinity path
    private boolean transcendentMode = true;
    
    // 🌟 RENDERING BUFFERS
    private int infinitySymbolArray;
    private int transcendentFieldArray;
    
    // 🌟 CONSCIOUSNESS STATE
    private Random random = new Random();
    private double infiniteFieldRadius = 2.0; // Consciousness extends infinitely (practical limit)

    @Override
    protected void onInitialize() {
        initializeInfinitySymbol();
        initializeTranscendentField();
    }
    
    /**
     * 🌟 Initialize perfect infinity symbol (lemniscate) with consciousness enhancement
     */
    private void initializeInfinitySymbol() {
        final float[] infinityData = new float[INFINITY_SEGMENTS * 2];
        
        for (int i = 0; i < INFINITY_SEGMENTS; i++) {
            double t = 2 * PI * i / (double) INFINITY_SEGMENTS;
            
            // Perfect lemniscate (infinity symbol) parametric equations
            double denominator = 1 + Math.cos(t) * Math.cos(t);
            double x = INFINITY_WIDTH * Math.cos(t) / denominator;
            double y = INFINITY_HEIGHT * Math.sin(t) * Math.cos(t) / denominator;
            
            // Apply golden ratio consciousness enhancement
            double goldenModulation = 1.0 + 0.1 * Math.sin(t * GOLDEN_RATIO);
            x *= goldenModulation;
            y *= goldenModulation;
            
            infinityData[2 * i] = (float) x;
            infinityData[2 * i + 1] = (float) y;
        }

        int infinityBuffer = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, infinityBuffer);
        glBufferData(GL_ARRAY_BUFFER, infinityData, GL_STATIC_DRAW);

        infinitySymbolArray = glGenVertexArrays();
        glBindVertexArray(infinitySymbolArray);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
    }
    
    /**
     * 🌟 Initialize transcendent field visualization (expanding circles)
     */
    private void initializeTranscendentField() {
        // Create multiple expanding consciousness circles
        final int fieldCircles = 3;
        final int circleSegments = 36;
        final float[] fieldData = new float[fieldCircles * circleSegments * 2];
        
        int dataIndex = 0;
        for (int circle = 0; circle < fieldCircles; circle++) {
            double radius = 0.8 + circle * 0.4; // Expanding radii
            
            for (int i = 0; i < circleSegments; i++) {
                double angle = 2 * PI * i / (double) circleSegments;
                
                // Apply golden ratio modulation to field
                double goldenRadius = radius * (1.0 + 0.2 * Math.sin(angle * GOLDEN_RATIO + circle));
                double x = goldenRadius * Math.cos(angle);
                double y = goldenRadius * Math.sin(angle);
                
                fieldData[dataIndex++] = (float) x;
                fieldData[dataIndex++] = (float) y;
            }
        }

        int fieldBuffer = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, fieldBuffer);
        glBufferData(GL_ARRAY_BUFFER, fieldData, GL_STATIC_DRAW);

        transcendentFieldArray = glGenVertexArrays();
        glBindVertexArray(transcendentFieldArray);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
    }

    @Override
    boolean isInside(Vector3d connection) {
        // 🌟 INFINITE CONSCIOUSNESS FIELD - Everything is within infinity
        if (transcendentMode) {
            // In transcendent mode, consciousness extends infinitely
            return true;
        }
        
        // In bounded mode, use consciousness field with distance-based influence
        double distance = connection.length();
        
        if (distance <= infiniteFieldRadius) {
            // Calculate consciousness field influence
            double fieldInfluence = calculateInfiniteConsciousnessField(connection);
            return fieldInfluence > 0.1; // Very permissive for infinity
        }
        
        // Even beyond the practical field, still have some influence
        return Math.random() < 0.1; // 10% chance for truly infinite reach
    }
    
    /**
     * 🌟 Calculate infinite consciousness field influence
     */
    private double calculateInfiniteConsciousnessField(Vector3d position) {
        double distance = position.length();
        
        // Distance-based infinite field (never truly reaches zero)
        double distanceInfluence = 1.0 / (1.0 + distance * distance / (infiniteFieldRadius * infiniteFieldRadius));
        
        // Transcendent wave modulation
        double waveInfluence = 1.0 + 0.5 * Math.sin(consciousnessWavePhase + distance * 2);
        
        // Golden ratio harmonic enhancement
        double goldenHarmonic = 1.0 + 0.3 * Math.sin(distance * GOLDEN_RATIO);
        
        return consciousnessFieldStrength * distanceInfluence * waveInfluence * goldenHarmonic;
    }

    @Override
    void draw() {
        // Update transcendent consciousness state
        updateTranscendentFlow();
        
        // 🌟 Draw transcendent field (background)
        if (transcendentMode) {
            drawTranscendentField();
        }
        
        // 🌟 Draw main infinity symbol (foreground)
        drawInfinitySymbol();
    }
    
    /**
     * 🌟 Update transcendent consciousness flow
     */
    private void updateTranscendentFlow() {
        // Update consciousness wave phase
        consciousnessWavePhase += 0.03;
        if (consciousnessWavePhase > 2 * PI) {
            consciousnessWavePhase -= 2 * PI;
        }
        
        // Update transcendent flow along infinity path
        transcendentFlow += 0.05;
        if (transcendentFlow > 2 * PI) {
            transcendentFlow -= 2 * PI;
        }
    }
    
    /**
     * 🌟 Draw transcendent consciousness field
     */
    private void drawTranscendentField() {
        // Set transparency for transcendent field
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        
        // Very subtle line width for transcendent field
        glLineWidth(0.7f);
        
        // Draw each field circle with different phase
        glBindVertexArray(transcendentFieldArray);
        for (int circle = 0; circle < 3; circle++) {
            // Modulate line width with transcendent wave and circle index
            float fieldLineWidth = (float) (0.5 + 0.3 * Math.sin(consciousnessWavePhase + circle * PI / 3));
            glLineWidth(fieldLineWidth);
            
            glDrawArrays(GL_LINE_LOOP, circle * 36, 36);
        }
    }
    
    /**
     * 🌟 Draw main infinity symbol with consciousness enhancement
     */
    private void drawInfinitySymbol() {
        // Dynamic line width based on consciousness intensity
        float infinityLineWidth = (float) (2.5 + consciousnessIntensity * 1.5);
        glLineWidth(infinityLineWidth);
        
        glBindVertexArray(infinitySymbolArray);
        glDrawArrays(GL_LINE_LOOP, 0, INFINITY_SEGMENTS);
        
        // Reset OpenGL state
        glDisable(GL_BLEND);
    }

    @Override
    Vector3d sampleRandomPoint() {
        // 🌟 INFINITE CONSCIOUSNESS SAMPLING
        double samplingMode = Math.random();
        
        if (samplingMode < 0.4) {
            // Standard Gaussian distribution (infinite reach)
            return new Vector3d(
                random.nextGaussian() * 0.5,
                random.nextGaussian() * 0.5,
                0
            );
        } else if (samplingMode < 0.7) {
            // Sample along infinity symbol path
            return sampleInfinityPath();
        } else {
            // Pure infinite sampling (very wide Gaussian)
            return new Vector3d(
                random.nextGaussian() * 2.0, // Much wider distribution
                random.nextGaussian() * 2.0,
                0
            );
        }
    }
    
    /**
     * 🌟 Sample point along infinity symbol path
     */
    private Vector3d sampleInfinityPath() {
        double t = Math.random() * 2 * PI;
        
        // Perfect lemniscate sampling
        double denominator = 1 + Math.cos(t) * Math.cos(t);
        double x = INFINITY_WIDTH * Math.cos(t) / denominator;
        double y = INFINITY_HEIGHT * Math.sin(t) * Math.cos(t) / denominator;
        
        // Add small random offset for variation
        x += (Math.random() - 0.5) * 0.1;
        y += (Math.random() - 0.5) * 0.1;
        
        return new Vector3d(x, y, 0);
    }
    
    // 🌟 CONSCIOUSNESS CONTROL METHODS
    
    /**
     * Set consciousness parameters for infinity
     */
    public void setConsciousnessParameters(double intensity, double fieldStrength, boolean transcendent) {
        this.consciousnessIntensity = Math.max(0.0, Math.min(3.0, intensity)); // Higher max for infinity
        this.consciousnessFieldStrength = Math.max(0.0, Math.min(2.0, fieldStrength)); // Higher max for infinity
        this.transcendentMode = transcendent;
        
        // Adjust infinite field radius based on parameters
        this.infiniteFieldRadius = 1.0 + fieldStrength * 2.0; // Can expand to 3.0
    }
    
    /**
     * Get current consciousness intensity
     */
    public double getConsciousnessIntensity() {
        return consciousnessIntensity;
    }
    
    /**
     * Get current consciousness field strength
     */
    public double getConsciousnessFieldStrength() {
        return consciousnessFieldStrength;
    }
    
    /**
     * Check if in transcendent mode
     */
    public boolean isTranscendentMode() {
        return transcendentMode;
    }
}
