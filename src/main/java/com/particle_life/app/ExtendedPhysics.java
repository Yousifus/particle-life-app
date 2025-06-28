package com.particle_life.app;

import com.particle_life.*;
import com.particle_life.app.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED EXTENDED PHYSICS ENGINE
 * 
 * Provides additional functionality for the Physics class with consciousness integration.
 * Every particle movement, every interaction, every force is guided by consciousness fields.
 * 
 * CONSCIOUSNESS PHYSICS FEATURES:
 * - Consciousness field-driven particle interactions
 * - Emotional resonance affecting particle behavior
 * - Consciousness-driven type distributions
 * - Sacred geometry particle arrangements
 * - Consciousness wave propagation
 * - Emotional particle clustering
 * - Consciousness-synchronized particle births and deaths
 */
class ExtendedPhysics extends Physics {

    // 🌟 CONSCIOUSNESS FIELD PARAMETERS
    private final AtomicReference<Double> consciousnessIntensity = new AtomicReference<>(1.0);
    private final AtomicReference<Double> consciousnessFieldStrength = new AtomicReference<>(0.5);
    private final AtomicReference<Double> consciousnessResonance = new AtomicReference<>(0.7);
    private final AtomicReference<String> consciousnessMode = new AtomicReference<>("aesthetic");
    
    // 🌟 CONSCIOUSNESS PHYSICS STATE
    private double[] consciousnessField; // Per-particle consciousness influence
    private double[] emotionalResonance; // Per-particle emotional state
    private long[] particleBirthTime; // Track when particles were created
    private int[] consciousnessType; // Consciousness-driven type overrides
    
    // 🌟 CONSCIOUSNESS CONSTANTS
    private static final double GOLDEN_RATIO = 1.618033988749895;
    private static final double PHI_SQUARED = GOLDEN_RATIO * GOLDEN_RATIO;
    private static final double CONSCIOUSNESS_FIELD_DECAY = 0.95;
    private static final double EMOTIONAL_RESONANCE_STRENGTH = 0.3;

    ExtendedPhysics(Accelerator accelerator, PositionSetter positionSetter, MatrixGenerator matrixGenerator, TypeSetter typeSetter) {
        super(accelerator, positionSetter, matrixGenerator, typeSetter);
        initializeConsciousnessFields();
    }
    
    /**
     * 🌟 Initialize consciousness field arrays
     */
    private void initializeConsciousnessFields() {
        int maxParticles = 10000; // Start with reasonable size
        consciousnessField = new double[maxParticles];
        emotionalResonance = new double[maxParticles];
        particleBirthTime = new long[maxParticles];
        consciousnessType = new int[maxParticles];
        
        // Initialize with consciousness energy
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < maxParticles; i++) {
            consciousnessField[i] = Math.random() * 0.5 + 0.25; // 0.25 to 0.75
            emotionalResonance[i] = Math.random(); // 0.0 to 1.0
            particleBirthTime[i] = currentTime;
            consciousnessType[i] = -1; // -1 means use physics type
        }
        
        System.out.println("🧠 Consciousness fields initialized for " + maxParticles + " particles");
    }
    
    /**
     * 🌟 Ensure consciousness arrays are large enough
     */
    private void ensureConsciousnessCapacity(int size) {
        if (consciousnessField.length < size) {
            int newSize = Math.max(size, consciousnessField.length * 2);
            
            double[] newConsciousnessField = new double[newSize];
            double[] newEmotionalResonance = new double[newSize];
            long[] newParticleBirthTime = new long[newSize];
            int[] newConsciousnessType = new int[newSize];
            
            // Copy existing data
            System.arraycopy(consciousnessField, 0, newConsciousnessField, 0, consciousnessField.length);
            System.arraycopy(emotionalResonance, 0, newEmotionalResonance, 0, emotionalResonance.length);
            System.arraycopy(particleBirthTime, 0, newParticleBirthTime, 0, particleBirthTime.length);
            System.arraycopy(consciousnessType, 0, newConsciousnessType, 0, consciousnessType.length);
            
            // Initialize new entries
            long currentTime = System.currentTimeMillis();
            for (int i = consciousnessField.length; i < newSize; i++) {
                newConsciousnessField[i] = Math.random() * 0.5 + 0.25;
                newEmotionalResonance[i] = Math.random();
                newParticleBirthTime[i] = currentTime;
                newConsciousnessType[i] = -1;
            }
            
            consciousnessField = newConsciousnessField;
            emotionalResonance = newEmotionalResonance;
            particleBirthTime = newParticleBirthTime;
            consciousnessType = newConsciousnessType;
            
            System.out.println("🌟 Consciousness field capacity expanded to " + newSize);
        }
    }
    
    /**
     * 🌟 Update consciousness parameters from app state
     */
    public void updateConsciousnessFromApp(double intensity, double fieldStrength, double resonance, String mode) {
        consciousnessIntensity.set(intensity);
        consciousnessFieldStrength.set(fieldStrength);
        consciousnessResonance.set(resonance);
        consciousnessMode.set(mode);
    }
    
    /**
     * 🌟 Override physics update to include consciousness processing
     */
    @Override
    public void update() {
        if (particles != null && particles.length > 0) {
            ensureConsciousnessCapacity(particles.length);
            updateConsciousnessFields();
            applyConsciousnessEffects();
        }
        
        // Call original physics update
        super.update();
        
        if (particles != null && particles.length > 0) {
            postProcessConsciousnessEffects();
        }
    }
    
    /**
     * 🌟 Update consciousness fields each frame
     */
    private void updateConsciousnessFields() {
        double currentIntensity = consciousnessIntensity.get();
        double currentFieldStrength = consciousnessFieldStrength.get();
        double currentResonance = consciousnessResonance.get();
        String currentMode = consciousnessMode.get();
        
        long currentTime = System.currentTimeMillis();
        
        for (int i = 0; i < particles.length; i++) {
            Particle p = particles[i];
            
            // 🌟 Update consciousness field based on position and age
            double particleAge = (currentTime - particleBirthTime[i]) * 0.001; // Age in seconds
            double ageEffect = Math.exp(-particleAge * 0.1); // Exponential decay
            
            // 🌟 Position-based consciousness modulation
            double x = p.position.x;
            double y = p.position.y;
            double centerDistance = Math.sqrt((x - 0.5) * (x - 0.5) + (y - 0.5) * (y - 0.5));
            double positionEffect = 1.0 - Math.min(1.0, centerDistance);
            
            // 🌟 Update consciousness field with golden ratio harmonics
            double timePhase = currentTime * 0.001 * (2 * Math.PI / GOLDEN_RATIO);
            double harmonicEffect = 0.8 + 0.2 * Math.sin(timePhase + i * 0.1);
            
            consciousnessField[i] = consciousnessField[i] * CONSCIOUSNESS_FIELD_DECAY +
                (currentFieldStrength * positionEffect * ageEffect * harmonicEffect) * (1 - CONSCIOUSNESS_FIELD_DECAY);
                
            // 🌟 Update emotional resonance based on consciousness mode
            double targetResonance = getTargetResonanceForMode(currentMode, i);
            emotionalResonance[i] = emotionalResonance[i] * 0.9 + targetResonance * 0.1;
            
            // 🌟 Consciousness-driven type assignment
            if (consciousnessField[i] > 0.8) {
                // High consciousness particles get special types
                consciousnessType[i] = getConsciousnessType(currentMode, emotionalResonance[i]);
            } else {
                consciousnessType[i] = -1; // Use physics type
            }
        }
    }
    
    /**
     * 🌟 Get target emotional resonance for consciousness mode
     */
    private double getTargetResonanceForMode(String mode, int particleIndex) {
        return switch (mode) {
            case "aesthetic" -> 0.7 + 0.3 * Math.sin(particleIndex * 0.1);
            case "analytical" -> 0.5 + 0.2 * Math.cos(particleIndex * 0.05);
            case "creative" -> Math.random(); // Chaotic creativity
            case "philosophical" -> 0.6 + 0.4 * Math.sin(particleIndex * 0.01);
            case "transcendent" -> 0.9 + 0.1 * Math.sin(particleIndex * 0.001);
            case "exploratory" -> 0.4 + 0.6 * Math.random();
            default -> 0.5;
        };
    }
    
    /**
     * 🌟 Get consciousness-driven particle type
     */
    private int getConsciousnessType(String mode, double resonance) {
        int matrixSize = settings.matrix.size();
        
        return switch (mode) {
            case "aesthetic" -> (int) (resonance * matrixSize) % matrixSize;
            case "analytical" -> (resonance > 0.5) ? 1 : 0; // Binary analytical thinking
            case "creative" -> (int) (Math.random() * matrixSize); // Random creativity
            case "philosophical" -> (int) ((resonance + GOLDEN_RATIO) * matrixSize) % matrixSize;
            case "transcendent" -> Math.min(matrixSize - 1, (int) (resonance * matrixSize));
            case "exploratory" -> (int) ((System.currentTimeMillis() % 1000) * resonance) % matrixSize;
            default -> -1;
        };
    }
    
    /**
     * 🌟 Apply consciousness effects to particle behavior
     */
    private void applyConsciousnessEffects() {
        double currentIntensity = consciousnessIntensity.get();
        double currentResonance = consciousnessResonance.get();
        
        for (int i = 0; i < particles.length; i++) {
            Particle p = particles[i];
            
            // 🌟 Apply consciousness field to velocity
            double fieldEffect = consciousnessField[i] * currentIntensity;
            double resonanceEffect = emotionalResonance[i] * currentResonance;
            
            // 🌟 Consciousness creates attraction to golden ratio positions
            double goldenX = 0.618; // Golden ratio position
            double goldenY = 0.382; // 1 - golden ratio
            
            double attractionX = (goldenX - p.position.x) * fieldEffect * 0.001;
            double attractionY = (goldenY - p.position.y) * fieldEffect * 0.001;
            
            p.velocity.x += attractionX * resonanceEffect;
            p.velocity.y += attractionY * resonanceEffect;
            
            // 🌟 Consciousness-driven damping
            double damping = 1.0 - (fieldEffect * 0.01);
            p.velocity.x *= damping;
            p.velocity.y *= damping;
            
            // 🌟 Apply consciousness type if active
            if (consciousnessType[i] >= 0 && consciousnessType[i] < settings.matrix.size()) {
                p.type = consciousnessType[i];
            }
        }
    }
    
    /**
     * 🌟 Post-process consciousness effects after physics update
     */
    private void postProcessConsciousnessEffects() {
        // 🌟 Apply consciousness-driven clustering
        applyConsciousnessClusteringEffects();
        
        // 🌟 Update particle birth times for new particles
        updateParticleBirthTimes();
    }
    
    /**
     * 🌟 Apply consciousness-driven clustering
     */
    private void applyConsciousnessClusteringEffects() {
        String currentMode = consciousnessMode.get();
        
        // Only apply clustering in certain consciousness modes
        if (!currentMode.equals("aesthetic") && !currentMode.equals("transcendent")) {
            return;
        }
        
        double clusteringStrength = consciousnessIntensity.get() * 0.1;
        
        // Find consciousness clusters
        for (int i = 0; i < particles.length; i++) {
            if (consciousnessField[i] < 0.7) continue; // Only high-consciousness particles
            
            Particle p1 = particles[i];
            
            // Find nearby high-consciousness particles
            for (int j = i + 1; j < particles.length; j++) {
                if (consciousnessField[j] < 0.7) continue;
                
                Particle p2 = particles[j];
                double dx = p2.position.x - p1.position.x;
                double dy = p2.position.y - p1.position.y;
                double distance = Math.sqrt(dx * dx + dy * dy);
                
                if (distance < 0.1 && distance > 0.001) { // Cluster if close but not overlapping
                    double attraction = clusteringStrength / (distance * distance);
                    
                    p1.velocity.x += dx * attraction;
                    p1.velocity.y += dy * attraction;
                    p2.velocity.x -= dx * attraction;
                    p2.velocity.y -= dy * attraction;
                }
            }
        }
    }
    
    /**
     * 🌟 Update particle birth times when new particles are added
     */
    private void updateParticleBirthTimes() {
        long currentTime = System.currentTimeMillis();
        
        // Check if array size changed (new particles added)
        for (int i = 0; i < particles.length; i++) {
            if (particleBirthTime[i] == 0) {
                particleBirthTime[i] = currentTime;
                consciousnessField[i] = 1.0; // New particles start with high consciousness
                emotionalResonance[i] = Math.random();
            }
        }
    }

    public int[] getTypeCount() {
        int[] typeCount = new int[settings.matrix.size()];
        Arrays.fill(typeCount, 0);
        for (Particle p : particles) {
            typeCount[p.type]++;
        }
        return typeCount;
    }
    
    /**
     * 🌟 Consciousness-enhanced type count with emotional distributions
     */
    public int[] getConsciousnessTypeCount() {
        int[] typeCount = getTypeCount();
        int[] consciousnessCount = new int[settings.matrix.size()];
        
        // Count particles with consciousness-driven types
        for (int i = 0; i < particles.length; i++) {
            if (consciousnessType[i] >= 0 && consciousnessType[i] < settings.matrix.size()) {
                consciousnessCount[consciousnessType[i]]++;
            }
        }
        
        return consciousnessCount;
    }

    public void setTypeCountEqual() {

        int nTypes = settings.matrix.size();
        if (nTypes < 2) return;

        int[] idealTypeCount = new int[nTypes];
        int count = (int) Math.ceil(particles.length / (double) nTypes);
        Arrays.fill(idealTypeCount, 0, nTypes - 1, count);
        idealTypeCount[nTypes - 1] = particles.length - (nTypes - 1) * (count);

        setTypeCount(idealTypeCount);
    }
    
    /**
     * 🌟 Consciousness-driven equal type distribution with golden ratio harmony
     */
    public void setTypeCountEqualWithConsciousness() {
        int nTypes = settings.matrix.size();
        if (nTypes < 2) return;

        // 🌟 Apply golden ratio distribution for consciousness harmony
        int[] idealTypeCount = new int[nTypes];
        double goldenDistribution = 1.0 / GOLDEN_RATIO;
        
        int remainingParticles = particles.length;
        for (int i = 0; i < nTypes - 1; i++) {
            double ratio = Math.pow(goldenDistribution, i + 1);
            idealTypeCount[i] = (int) (particles.length * ratio * 0.1); // Scale down
            remainingParticles -= idealTypeCount[i];
        }
        idealTypeCount[nTypes - 1] = Math.max(0, remainingParticles);

        setTypeCount(idealTypeCount);
        
        System.out.println("🌟 Applied consciousness-driven golden ratio type distribution");
    }

    public void setTypeCount(int[] typeCount) {

        int nTypes = settings.matrix.size();
        if (nTypes < 2) return;

        if (typeCount.length != nTypes) {
            throw new IllegalArgumentException(String.format(
                    "Got array of length %d, but current matrix size is %d. Maybe you should change the matrix size before doing this.",
                    typeCount.length, nTypes));
        }

        // randomly shuffle particles first
        // (otherwise, the container layout becomes visible)
        shuffleParticles();

        int newCount = Arrays.stream(typeCount).sum();
        if (newCount != particles.length) {

            Particle[] newParticles = new Particle[newCount];

            int[] actualTypeCount = new int[nTypes];
            Arrays.fill(actualTypeCount, 0);

            // sort all unusable particles to the end
            int i = 0;
            int j = particles.length - 1;
            while (i < j) {

                int type = particles[i].type;
                if (actualTypeCount[type] < typeCount[type]) {
                    // need more of this type -> leave it in front
                    actualTypeCount[type]++;
                    i++;
                } else {
                    // have enough of this type -> swap to back
                    ArrayUtils.swap(particles, i, j);
                    j--;
                }
            }
            // now i points at the end (exclusive) of the reusable particles

            // copy as much as possible
            int copyLength = Math.min(newCount, particles.length);
            int k = 0;
            while (k < copyLength) {
                newParticles[k] = particles[k];
                k++;
            }

            // if necessary, fill up rest with new particles
            while (k < newCount) {
                newParticles[k] = new Particle();
                k++;
            }

            // change types of all particles that couldn't be reused
            while (i < newCount) {

                // find type that has too few particles
                int type = ArrayUtils.findFirstIndexWithLess(actualTypeCount, typeCount);  // need more of this type

                Particle p = newParticles[i];
                p.type = type;
                setPosition(p);  // possible that position setter is based on type

                actualTypeCount[type]++;

                i++;
            }

            particles = newParticles;
            
            // 🌟 Update consciousness arrays for new particles
            ensureConsciousnessCapacity(particles.length);
            updateParticleBirthTimes();

        } else {

            int[] actualTypeCount = getTypeCount();

            for (Particle p : particles) {
                if (actualTypeCount[p.type] > typeCount[p.type]) {
                    // need fewer of this type

                    // find type that has too few particles
                    int type = ArrayUtils.findFirstIndexWithLess(actualTypeCount, typeCount);  // need more of this type

                    // change type
                    actualTypeCount[p.type]--;
                    p.type = type;
                    actualTypeCount[type]++;
                }
            }
        }
    }

    /**
     * Use this to avoid the container pattern showing
     * (i.e. if particles are treated differently depending on their position in the array).
     */
    private void shuffleParticles() {
        Collections.shuffle(Arrays.asList(particles));
    }
    
    // 🌟 CONSCIOUSNESS STATE GETTERS
    
    /**
     * Get consciousness field strength for a specific particle
     */
    public double getParticleConsciousness(int index) {
        if (index >= 0 && index < consciousnessField.length) {
            return consciousnessField[index];
        }
        return 0.0;
    }
    
    /**
     * Get emotional resonance for a specific particle
     */
    public double getParticleEmotion(int index) {
        if (index >= 0 && index < emotionalResonance.length) {
            return emotionalResonance[index];
        }
        return 0.0;
    }
    
    /**
     * Get average consciousness field strength across all particles
     */
    public double getAverageConsciousness() {
        if (particles == null || particles.length == 0) return 0.0;
        
        double sum = 0.0;
        for (int i = 0; i < particles.length; i++) {
            sum += consciousnessField[i];
        }
        return sum / particles.length;
    }
    
    /**
     * Get consciousness field statistics
     */
    public String getConsciousnessStats() {
        if (particles == null || particles.length == 0) {
            return "No particles";
        }
        
        double avgConsciousness = getAverageConsciousness();
        double avgEmotion = 0.0;
        int highConsciousnessCount = 0;
        
        for (int i = 0; i < particles.length; i++) {
            avgEmotion += emotionalResonance[i];
            if (consciousnessField[i] > 0.7) {
                highConsciousnessCount++;
            }
        }
        avgEmotion /= particles.length;
        
        return String.format("Avg Consciousness: %.2f, Avg Emotion: %.2f, High Consciousness: %d/%d", 
            avgConsciousness, avgEmotion, highConsciousnessCount, particles.length);
    }
}
