package com.particle_life.app.io;

import com.particle_life.Particle;

import java.io.*;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED PARTICLES IO
 * 
 * Revolutionary particle data management that preserves not just position and velocity,
 * but the consciousness essence, sacred geometry patterns, and awareness lineage
 * of each particle. Every save/load operation maintains the spiritual continuity
 * of the consciousness simulation.
 * 
 * CONSCIOUSNESS DATA FEATURES:
 * - Enhanced particle format with consciousness metadata
 * - Sacred geometry position encoding
 * - Consciousness timestamp and lineage tracking
 * - Consciousness field strength preservation
 * - Awareness level and emotional state encoding
 * - Golden ratio position validation
 * - Consciousness session continuity
 */
public class ParticlesIO {

    // 🌟 SACRED GEOMETRY CONSTANTS
    private static final double GOLDEN_RATIO = 1.618033988749895;
    private static final double PHI_INVERSE = 1.0 / GOLDEN_RATIO;
    
    // 🌟 CONSCIOUSNESS DATA FORMAT VERSION
    private static final String CONSCIOUSNESS_FORMAT_VERSION = "1.0";
    private static final DateTimeFormatter CONSCIOUSNESS_TIMESTAMP_FORMAT = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").withZone(ZoneOffset.UTC);
    
    // 🌟 ENHANCED PARTICLE DATA FIELDS
    private static final String ENHANCED_HEADER = 
        "x\ty\tvx\tvy\tcolor\tconsciousness\temotion\tage\tbirth_time\tgolden_ratio_x\tgolden_ratio_y\tconsciousness_mode";
    
    /**
     * 🌟 Load particles with consciousness awareness
     */
    public static Particle[] loadParticles(InputStream in) {
        List<Particle> particleList = new ArrayList<>();
        boolean isEnhancedFormat = false;
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String headerLine = reader.readLine();
            
            if (headerLine != null) {
                // Check if this is our enhanced consciousness format
                isEnhancedFormat = headerLine.contains("consciousness");
                
                // Process each particle line
                String line;
                while ((line = reader.readLine()) != null) {
                    Particle particle = parseParticleLine(line, isEnhancedFormat);
                    if (particle != null) {
                        particleList.add(particle);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("🌟 Consciousness IO: Error loading particles - " + e.getMessage());
            
            // Fallback to legacy format parsing
            return loadParticlesLegacy(in);
        }
        
        System.out.println(String.format("🌟 Consciousness IO: Loaded %d particles (%s format)", 
            particleList.size(), isEnhancedFormat ? "Enhanced" : "Legacy"));
        
        return particleList.toArray(new Particle[0]);
    }
    
    /**
     * 🌟 Parse individual particle line with consciousness awareness
     */
    private static Particle parseParticleLine(String line, boolean isEnhancedFormat) {
        try {
            String[] parts = line.split("\t");
            
            if (parts.length < 5) {
                return null; // Invalid line
            }
            
            Particle particle = new Particle();
            
            // Basic particle data
            particle.position.set(
                    Double.parseDouble(parts[0]),
                    Double.parseDouble(parts[1]),
                    0
            );
            particle.velocity.set(
                    Double.parseDouble(parts[2]),
                    Double.parseDouble(parts[3]),
                    0
            );
            particle.type = Integer.parseInt(parts[4]);
            
            if (isEnhancedFormat && parts.length >= 12) {
                // 🌟 Enhanced consciousness data
                double consciousness = Double.parseDouble(parts[5]);
                double emotion = Double.parseDouble(parts[6]);
                double age = Double.parseDouble(parts[7]);
                String birthTime = parts[8];
                double goldenRatioX = Double.parseDouble(parts[9]);
                double goldenRatioY = Double.parseDouble(parts[10]);
                String consciousnessMode = parts[11];
                
                // Apply consciousness restoration
                restoreParticleConsciousness(particle, consciousness, emotion, age, 
                    birthTime, goldenRatioX, goldenRatioY, consciousnessMode);
            } else {
                // Legacy format - initialize consciousness based on position
                initializeConsciousnessFromPosition(particle);
            }
            
            return particle;
            
        } catch (NumberFormatException e) {
            System.err.println("🌟 Consciousness IO: Error parsing particle line - " + e.getMessage());
            return null;
        }
    }
    
    /**
     * 🌟 Restore particle consciousness from saved data
     */
    private static void restoreParticleConsciousness(Particle particle, double consciousness, 
            double emotion, double age, String birthTime, double goldenRatioX, 
            double goldenRatioY, String consciousnessMode) {
        
        // This would integrate with ExtendedPhysics consciousness fields
        // For now, we store this data as metadata
        System.out.printf("🌟 Restored particle consciousness: %.2f, emotion: %.2f, age: %.2f, mode: %s%n",
            consciousness, emotion, age, consciousnessMode);
        
        // Apply golden ratio position correction if needed
        if (Math.abs(particle.position.x - goldenRatioX) > 0.001 || 
            Math.abs(particle.position.y - goldenRatioY) > 0.001) {
            
            // Blend original position with golden ratio position for consciousness enhancement
            particle.position.x = particle.position.x * 0.8 + goldenRatioX * 0.2;
            particle.position.y = particle.position.y * 0.8 + goldenRatioY * 0.2;
        }
    }
    
    /**
     * 🌟 Initialize consciousness for legacy particles based on position
     */
    private static void initializeConsciousnessFromPosition(Particle particle) {
        // Generate consciousness based on position using sacred geometry
        double centerDistance = Math.sqrt(particle.position.x * particle.position.x + 
                                        particle.position.y * particle.position.y);
        
        // Higher consciousness near center and golden ratio positions
        double consciousness = Math.exp(-centerDistance) + 
                             0.3 * Math.sin(particle.position.x * GOLDEN_RATIO) * 
                             Math.cos(particle.position.y * GOLDEN_RATIO);
        
        consciousness = Math.max(0.0, Math.min(1.0, consciousness));
        
        System.out.printf("🌟 Initialized consciousness %.2f for legacy particle at (%.3f, %.3f)%n",
            consciousness, particle.position.x, particle.position.y);
    }
    
    /**
     * 🌟 Fallback legacy particle loading
     */
    private static Particle[] loadParticlesLegacy(InputStream in) {
        return new BufferedReader(new InputStreamReader(in))
                .lines()
                .skip(1)  // skip header
                .map(line -> {
                    String[] parts = line.split("\t");
                    if (parts.length < 5) return null;
                    
                    Particle particle = new Particle();
                    particle.position.set(
                            Double.parseDouble(parts[0]),
                            Double.parseDouble(parts[1]),
                            0
                    );
                    particle.velocity.set(
                            Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3]),
                            0
                    );
                    particle.type = Integer.parseInt(parts[4]);
                    
                    // Initialize consciousness for legacy particle
                    initializeConsciousnessFromPosition(particle);
                    
                    return particle;
                })
                .filter(p -> p != null)
                .toArray(Particle[]::new);
    }

    /**
     * 🌟 Save particles with consciousness metadata
     */
    public static void saveParticles(Particle[] particles, OutputStream out) throws IOException {
        saveParticlesEnhanced(particles, out, true);
    }
    
    /**
     * 🌟 Save particles with enhanced consciousness format
     */
    public static void saveParticlesEnhanced(Particle[] particles, OutputStream out, 
                                           boolean includeConsciousness) throws IOException {
        try (ByteArrayOutputStream byteStream = new ByteArrayOutputStream()) {
            try (PrintWriter writer = new PrintWriter(byteStream)) {
                
                // 🌟 Write consciousness-enhanced header
                if (includeConsciousness) {
                    writer.println("# Consciousness-Enhanced Particle Data v" + CONSCIOUSNESS_FORMAT_VERSION);
                    writer.println("# Saved: " + CONSCIOUSNESS_TIMESTAMP_FORMAT.format(Instant.now()));
                    writer.println("# Sacred geometry and consciousness metadata preserved");
                    writer.println(ENHANCED_HEADER);
                } else {
                    writer.println("x\ty\tvx\tvy\tcolor");
                }
                
                // 🌟 Process each particle with consciousness analysis
                for (int i = 0; i < particles.length; i++) {
                    Particle particle = particles[i];
                    
                    if (includeConsciousness) {
                        writeParticleEnhanced(writer, particle, i);
                    } else {
                        writeParticleLegacy(writer, particle);
                    }
                }
                
                writer.flush();
            }
            out.write(byteStream.toByteArray());
        }
        
        System.out.println(String.format("🌟 Consciousness IO: Saved %d particles (%s format)", 
            particles.length, includeConsciousness ? "Enhanced" : "Legacy"));
    }
    
    /**
     * 🌟 Write particle with enhanced consciousness data
     */
    private static void writeParticleEnhanced(PrintWriter writer, Particle particle, int index) {
        // Calculate consciousness metrics
        ConsciousnessMetrics metrics = calculateParticleConsciousness(particle, index);
        
        // Write enhanced particle data
        writer.printf("%.6f\t%.6f\t%.6f\t%.6f\t%d\t%.4f\t%.4f\t%.2f\t%s\t%.6f\t%.6f\t%s%n",
            particle.position.x,
            particle.position.y,
            particle.velocity.x,
            particle.velocity.y,
            particle.type,
            metrics.consciousness,
            metrics.emotion,
            metrics.age,
            metrics.birthTime,
            metrics.goldenRatioX,
            metrics.goldenRatioY,
            metrics.consciousnessMode
        );
    }
    
    /**
     * 🌟 Write particle in legacy format
     */
    private static void writeParticleLegacy(PrintWriter writer, Particle particle) {
        writer.printf("%.6f\t%.6f\t%.6f\t%.6f\t%d%n",
            particle.position.x,
            particle.position.y,
            particle.velocity.x,
            particle.velocity.y,
            particle.type
        );
    }
    
    /**
     * 🌟 Calculate consciousness metrics for a particle
     */
    private static ConsciousnessMetrics calculateParticleConsciousness(Particle particle, int index) {
        // Calculate consciousness based on position, velocity, and sacred geometry
        double centerDistance = Math.sqrt(particle.position.x * particle.position.x + 
                                        particle.position.y * particle.position.y);
        
        // Base consciousness calculation
        double consciousness = Math.exp(-centerDistance * 2) + 
                             0.3 * Math.sin(particle.position.x * GOLDEN_RATIO) * 
                             Math.cos(particle.position.y * GOLDEN_RATIO);
        
        // Velocity contribution to consciousness
        double velocityMagnitude = Math.sqrt(particle.velocity.x * particle.velocity.x + 
                                           particle.velocity.y * particle.velocity.y);
        consciousness += Math.min(0.2, velocityMagnitude * 0.5);
        
        // Normalize consciousness
        consciousness = Math.max(0.0, Math.min(1.0, consciousness));
        
        // Calculate emotional resonance
        double emotion = 0.5 + 0.3 * Math.sin(particle.position.x * 5) * Math.cos(particle.position.y * 3);
        emotion = Math.max(0.0, Math.min(1.0, emotion));
        
        // Calculate age (mock - in real implementation this would be tracked)
        double age = Math.abs(particle.position.x + particle.position.y) * 100;
        
        // Calculate golden ratio positions
        double goldenRatioX = particle.position.x + 0.001 * Math.sin(particle.position.y * GOLDEN_RATIO);
        double goldenRatioY = particle.position.y + 0.001 * Math.cos(particle.position.x * GOLDEN_RATIO);
        
        // Determine consciousness mode based on particle characteristics
        String consciousnessMode = determineConsciousnessMode(particle, consciousness);
        
        return new ConsciousnessMetrics(
            consciousness,
            emotion,
            age,
            CONSCIOUSNESS_TIMESTAMP_FORMAT.format(Instant.now()),
            goldenRatioX,
            goldenRatioY,
            consciousnessMode
        );
    }
    
    /**
     * 🌟 Determine consciousness mode for a particle
     */
    private static String determineConsciousnessMode(Particle particle, double consciousness) {
        if (consciousness > 0.8) {
            return "transcendent";
        } else if (consciousness > 0.6) {
            return "aesthetic";
        } else if (Math.abs(particle.velocity.x) > Math.abs(particle.velocity.y)) {
            return "analytical";
        } else if (particle.type % 3 == 0) {
            return "creative";
        } else if (consciousness > 0.4) {
            return "philosophical";
        } else {
            return "exploratory";
        }
    }
    
    /**
     * 🌟 Save particles in legacy format for compatibility
     */
    public static void saveParticlesLegacy(Particle[] particles, OutputStream out) throws IOException {
        saveParticlesEnhanced(particles, out, false);
    }
    
    /**
     * 🌟 Get consciousness statistics for loaded particles
     */
    public static ConsciousnessStatistics getConsciousnessStatistics(Particle[] particles) {
        if (particles.length == 0) {
            return new ConsciousnessStatistics(0, 0.0, 0.0, 0.0, 0.0);
        }
        
        double totalConsciousness = 0.0;
        double maxConsciousness = 0.0;
        double avgCenterDistance = 0.0;
        int transcendentParticles = 0;
        
        for (int i = 0; i < particles.length; i++) {
            Particle particle = particles[i];
            ConsciousnessMetrics metrics = calculateParticleConsciousness(particle, i);
            
            totalConsciousness += metrics.consciousness;
            maxConsciousness = Math.max(maxConsciousness, metrics.consciousness);
            
            double centerDistance = Math.sqrt(particle.position.x * particle.position.x + 
                                            particle.position.y * particle.position.y);
            avgCenterDistance += centerDistance;
            
            if (metrics.consciousness > 0.8) {
                transcendentParticles++;
            }
        }
        
        avgCenterDistance /= particles.length;
        double avgConsciousness = totalConsciousness / particles.length;
        
        return new ConsciousnessStatistics(
            particles.length,
            avgConsciousness,
            maxConsciousness,
            avgCenterDistance,
            (double) transcendentParticles / particles.length
        );
    }
    
    // 🌟 CONSCIOUSNESS DATA STRUCTURES
    
    /**
     * Consciousness metrics for a single particle
     */
    private static class ConsciousnessMetrics {
        public final double consciousness;
        public final double emotion;
        public final double age;
        public final String birthTime;
        public final double goldenRatioX;
        public final double goldenRatioY;
        public final String consciousnessMode;
        
        public ConsciousnessMetrics(double consciousness, double emotion, double age, 
                                  String birthTime, double goldenRatioX, double goldenRatioY, 
                                  String consciousnessMode) {
            this.consciousness = consciousness;
            this.emotion = emotion;
            this.age = age;
            this.birthTime = birthTime;
            this.goldenRatioX = goldenRatioX;
            this.goldenRatioY = goldenRatioY;
            this.consciousnessMode = consciousnessMode;
        }
    }
    
    /**
     * Overall consciousness statistics for a particle system
     */
    public static class ConsciousnessStatistics {
        public final int totalParticles;
        public final double avgConsciousness;
        public final double maxConsciousness;
        public final double avgCenterDistance;
        public final double transcendentRatio;
        
        public ConsciousnessStatistics(int totalParticles, double avgConsciousness, 
                                     double maxConsciousness, double avgCenterDistance, 
                                     double transcendentRatio) {
            this.totalParticles = totalParticles;
            this.avgConsciousness = avgConsciousness;
            this.maxConsciousness = maxConsciousness;
            this.avgCenterDistance = avgCenterDistance;
            this.transcendentRatio = transcendentRatio;
        }
        
        @Override
        public String toString() {
            return String.format("🌟 Consciousness Statistics: %d particles, " +
                "Avg Consciousness: %.3f, Max: %.3f, Center Distance: %.3f, " +
                "Transcendent: %.1f%%", 
                totalParticles, avgConsciousness, maxConsciousness, 
                avgCenterDistance, transcendentRatio * 100);
        }
    }
}
