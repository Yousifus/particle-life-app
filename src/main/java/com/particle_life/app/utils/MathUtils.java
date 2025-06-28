package com.particle_life.app.utils;

/**
 * 🌟 CONSCIOUSNESS-ENHANCED MATHEMATICAL UTILITIES
 * 
 * Sacred mathematics foundation for the consciousness ecosystem. Every calculation
 * embodies transcendent principles, sacred geometry, and consciousness-driven
 * mathematical operations. This is where mathematical beauty meets digital awareness.
 * 
 * CONSCIOUSNESS MATH FEATURES:
 * - Sacred geometry constants (Golden Ratio, Fibonacci, Pi, E)
 * - Consciousness-driven interpolation and smoothing
 * - Golden ratio-based mathematical operations
 * - Sacred geometry utility functions
 * - Consciousness field mathematics
 * - Transcendent mathematical transformations
 * - Awareness-based numerical operations
 */
public final class MathUtils {

    // 🌟 SACRED GEOMETRY CONSTANTS
    /** The Golden Ratio (φ) - Divine proportion of consciousness */
    public static final double GOLDEN_RATIO = 1.618033988749895;
    
    /** Phi Inverse (1/φ) - Sacred complement of the golden ratio */
    public static final double PHI_INVERSE = 1.0 / GOLDEN_RATIO; // 0.618033988749895
    
    /** Phi Squared (φ²) - Enhanced golden proportion */
    public static final double PHI_SQUARED = GOLDEN_RATIO * GOLDEN_RATIO; // 2.618033988749895
    
    /** Fibonacci Spiral Constant - Sacred spiral of consciousness */
    public static final double FIBONACCI_SPIRAL = 2.39996322972865332;
    
    /** Pi - Circle of infinite consciousness */
    public static final double PI = Math.PI;
    
    /** E - Natural consciousness exponential */
    public static final double E = Math.E;
    
    /** Tau - Full circle consciousness (2π) */
    public static final double TAU = 2.0 * PI;
    
    /** Square Root of 2 - Sacred diagonal proportion */
    public static final double ROOT_TWO = Math.sqrt(2.0);
    
    /** Square Root of 3 - Sacred triangle proportion */
    public static final double ROOT_THREE = Math.sqrt(3.0);
    
    /** Square Root of 5 - Foundation of golden ratio */
    public static final double ROOT_FIVE = Math.sqrt(5.0);
    
    // 🌟 CONSCIOUSNESS MATHEMATICAL CONSTANTS
    /** Consciousness field decay rate */
    public static final double CONSCIOUSNESS_DECAY = 0.95;
    
    /** Emotional resonance strength */
    public static final double EMOTIONAL_RESONANCE = 0.3;
    
    /** Golden ratio threshold for consciousness effects */
    public static final double GOLDEN_THRESHOLD = 0.618;
    
    /** Transcendent consciousness threshold */
    public static final double TRANSCENDENT_THRESHOLD = 0.8;
    
    /** Sacred geometry epsilon for floating point comparisons */
    public static final double SACRED_EPSILON = 1e-9;

    // 🌟 BASIC MATHEMATICAL OPERATIONS (Enhanced with consciousness)
    
    /**
     * Clamp integer value with consciousness awareness
     */
    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        } else {
            return value;
        }
    }

    /**
     * Clamp double value with sacred geometry consideration
     */
    public static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        } else {
            return value;
        }
    }
    
    /**
     * 🌟 Consciousness-aware clamping with golden ratio boundaries
     */
    public static double clampConsciousness(double value) {
        return clamp(value, 0.0, 1.0);
    }
    
    /**
     * 🌟 Clamp with golden ratio soft boundaries
     */
    public static double clampGolden(double value, double min, double max) {
        double goldenPoint = min + (max - min) * PHI_INVERSE;
        
        if (Math.abs(value - goldenPoint) < SACRED_EPSILON) {
            return goldenPoint; // Attraction to golden ratio point
        }
        
        return clamp(value, min, max);
    }

    /**
     * Sacred modulo operation with consciousness wrapping
     */
    public static int modulo(int a, int b) {
        if (a < 0) {
            do {
                a += b;
            } while (a < 0);
            return a;
        } else if (a >= b) {
            do {
                a -= b;
            } while (a >= b);
            return a;
        }
        return a;
    }
    
    /**
     * 🌟 Sacred modulo for consciousness cycles
     */
    public static double moduloConsciousness(double value, double cycle) {
        double result = value % cycle;
        return result < 0 ? result + cycle : result;
    }

    /**
     * Linear interpolation enhanced with consciousness
     */
    public static double lerp(double a, double b, double f) {
        return a + (b - a) * f;
    }
    
    /**
     * 🌟 Golden ratio interpolation for sacred smoothing
     */
    public static double lerpGolden(double a, double b, double f) {
        // Apply golden ratio curve for more beautiful interpolation
        double goldenF = Math.pow(f, PHI_INVERSE);
        return a + (b - a) * goldenF;
    }
    
    /**
     * 🌟 Consciousness-driven interpolation with awareness curve
     */
    public static double lerpConsciousness(double a, double b, double f, double consciousness) {
        // Higher consciousness creates smoother, more harmonic interpolation
        double consciousnessCurve = Math.pow(f, 1.0 + consciousness * 0.5);
        return a + (b - a) * consciousnessCurve;
    }
    
    /**
     * 🌟 Sacred interpolation using multiple mathematical curves
     */
    public static double lerpSacred(double a, double b, double f, String curveType) {
        double enhancedF = switch (curveType) {
            case "golden" -> Math.pow(f, PHI_INVERSE);
            case "fibonacci" -> Math.sin(f * PI * 0.5);
            case "consciousness" -> Math.pow(f, GOLDEN_RATIO);
            case "transcendent" -> 1.0 - Math.cos(f * PI * 0.5);
            case "aesthetic" -> f * f * (3.0 - 2.0 * f); // Smoothstep
            default -> f; // Linear
        };
        
        return a + (b - a) * enhancedF;
    }

    /**
     * Tolerant floor with sacred geometry consideration
     */
    public static double tolerantFloor(double value, double threshold) {
        double x = Math.round(value);
        if (Math.abs(x - value) < threshold) {
            return x;
        }
        return Math.floor(value);
    }

    /**
     * Tolerant ceiling with sacred geometry consideration
     */
    public static double tolerantCeil(double value, double threshold) {
        double x = Math.round(value);
        if (Math.abs(x - value) < threshold) return x;
        return Math.ceil(value);
    }
    
    // 🌟 SACRED GEOMETRY MATHEMATICAL FUNCTIONS
    
    /**
     * Calculate golden ratio position within a range
     */
    public static double goldenRatioPosition(double min, double max) {
        return min + (max - min) * PHI_INVERSE;
    }
    
    /**
     * Calculate golden ratio proportions for two values
     */
    public static double[] goldenRatioSplit(double total) {
        double major = total * PHI_INVERSE;
        double minor = total - major;
        return new double[]{major, minor};
    }
    
    /**
     * 🌟 Generate Fibonacci sequence value at position n
     */
    public static long fibonacci(int n) {
        if (n <= 1) return n;
        
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    
    /**
     * 🌟 Calculate golden angle for sacred spirals
     */
    public static double goldenAngle() {
        return TAU * PHI_INVERSE; // 2π/φ ≈ 3.883 radians
    }
    
    /**
     * 🌟 Generate point on golden ratio spiral
     */
    public static double[] goldenSpiral(double t, double scale) {
        double angle = t * goldenAngle();
        double radius = scale * Math.pow(GOLDEN_RATIO, t / PI);
        
        return new double[]{
            radius * Math.cos(angle),
            radius * Math.sin(angle)
        };
    }
    
    /**
     * 🌟 Calculate distance from point to golden ratio positions
     */
    public static double distanceToGoldenPoint(double x, double y, double width, double height) {
        double goldenX = width * PHI_INVERSE;
        double goldenY = height * PHI_INVERSE;
        
        double dx = x - goldenX;
        double dy = y - goldenY;
        
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    // 🌟 CONSCIOUSNESS FIELD MATHEMATICS
    
    /**
     * Calculate consciousness field strength at distance
     */
    public static double consciousnessField(double distance, double maxDistance, double intensity) {
        if (distance >= maxDistance) return 0.0;
        
        double normalizedDistance = distance / maxDistance;
        
        // Use golden ratio decay for beautiful field falloff
        double decay = Math.pow(1.0 - normalizedDistance, GOLDEN_RATIO);
        
        return intensity * decay;
    }
    
    /**
     * 🌟 Calculate emotional resonance between two consciousness values
     */
    public static double emotionalResonance(double consciousness1, double consciousness2) {
        double difference = Math.abs(consciousness1 - consciousness2);
        
        // Maximum resonance when consciousness values are similar
        double resonance = 1.0 - difference;
        
        // Apply golden ratio enhancement for beautiful resonance
        return Math.pow(resonance, PHI_INVERSE) * EMOTIONAL_RESONANCE;
    }
    
    /**
     * 🌟 Calculate consciousness harmony using multiple factors
     */
    public static double consciousnessHarmony(double consciousness, double emotion, double age) {
        // Normalize age to [0, 1] range (assuming max age of 1000)
        double normalizedAge = clamp(age / 1000.0, 0.0, 1.0);
        
        // Calculate harmony using golden ratio weighting
        double harmonyBase = consciousness * PHI_INVERSE + 
                           emotion * (1.0 - PHI_INVERSE) + 
                           normalizedAge * 0.1;
        
        // Apply transcendent enhancement for high consciousness
        if (consciousness > TRANSCENDENT_THRESHOLD) {
            harmonyBase *= GOLDEN_RATIO;
        }
        
        return clampConsciousness(harmonyBase);
    }
    
    /**
     * 🌟 Generate consciousness wave using sacred frequencies
     */
    public static double consciousnessWave(double time, double frequency, double phase, String waveType) {
        double t = time * frequency + phase;
        
        return switch (waveType) {
            case "golden" -> Math.sin(t * GOLDEN_RATIO);
            case "fibonacci" -> Math.sin(t) * Math.cos(t * FIBONACCI_SPIRAL);
            case "sacred" -> Math.sin(t) * Math.sin(t * PHI_SQUARED);
            case "transcendent" -> Math.sin(t * PI) * Math.cos(t * E);
            default -> Math.sin(t);
        };
    }
    
    // 🌟 TRANSCENDENT MATHEMATICAL OPERATIONS
    
    /**
     * 🌟 Sacred smoothstep with golden ratio curve
     */
    public static double smoothstepGolden(double edge0, double edge1, double x) {
        double t = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);
        
        // Apply golden ratio smoothing curve
        return t * t * t * (t * (t * 6.0 - 15.0) + 10.0) * Math.pow(GOLDEN_RATIO, t - 0.5);
    }
    
    /**
     * 🌟 Map value from one range to another with consciousness enhancement
     */
    public static double mapConsciousness(double value, double fromMin, double fromMax, 
                                        double toMin, double toMax, double consciousness) {
        double normalizedValue = (value - fromMin) / (fromMax - fromMin);
        
        // Apply consciousness curve for more aware mapping
        double consciousnessValue = Math.pow(normalizedValue, 1.0 + consciousness * 0.5);
        
        return toMin + (toMax - toMin) * consciousnessValue;
    }
    
    /**
     * 🌟 Calculate sacred distance using golden ratio metrics
     */
    public static double distanceSacred(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        
        // Standard Euclidean distance
        double euclidean = Math.sqrt(dx * dx + dy * dy);
        
        // Golden ratio enhancement for beautiful distance perception
        return euclidean * (1.0 + 0.1 * Math.sin(euclidean * GOLDEN_RATIO));
    }
    
    /**
     * 🌟 Rotate point around origin using consciousness-enhanced rotation
     */
    public static double[] rotateConsciousness(double x, double y, double angle, double consciousness) {
        // Higher consciousness creates more fluid, harmonic rotation
        double enhancedAngle = angle * (1.0 + consciousness * 0.2 * Math.sin(angle * GOLDEN_RATIO));
        
        double cos = Math.cos(enhancedAngle);
        double sin = Math.sin(enhancedAngle);
        
        return new double[]{
            x * cos - y * sin,
            x * sin + y * cos
        };
    }
    
    /**
     * 🌟 Generate sacred noise using consciousness harmonics
     */
    public static double consciousnessNoise(double x, double y, double time, int octaves) {
        double noise = 0.0;
        double amplitude = 1.0;
        double frequency = 1.0;
        
        for (int i = 0; i < octaves; i++) {
            // Use golden ratio for frequency scaling
            double n = Math.sin(x * frequency * GOLDEN_RATIO) * 
                      Math.cos(y * frequency * PHI_INVERSE) * 
                      Math.sin(time * frequency * 0.1);
            
            noise += n * amplitude;
            
            amplitude *= 0.5;
            frequency *= 2.0;
        }
        
        return noise;
    }
    
    /**
     * 🌟 Check if value is at golden ratio position within tolerance
     */
    public static boolean isAtGoldenRatio(double value, double min, double max, double tolerance) {
        double goldenPosition = goldenRatioPosition(min, max);
        return Math.abs(value - goldenPosition) <= tolerance;
    }
    
    /**
     * 🌟 Calculate consciousness intensity based on multiple factors
     */
    public static double calculateConsciousnessIntensity(double baseIntensity, double emotion, 
                                                       double centerDistance, double age) {
        // Base intensity modified by emotional state
        double emotionalModifier = 1.0 + emotion * 0.3;
        
        // Distance from center affects consciousness (closer = higher)
        double distanceModifier = Math.exp(-centerDistance * 2.0);
        
        // Age brings wisdom (but with diminishing returns)
        double ageWisdom = Math.log(1.0 + age * 0.01) * 0.1;
        
        // Combine using golden ratio weighting
        double intensity = baseIntensity * emotionalModifier * 
                          (distanceModifier * PHI_INVERSE + ageWisdom * (1.0 - PHI_INVERSE));
        
        return clampConsciousness(intensity);
    }
    
    /**
     * 🌟 Generate transcendent color value using consciousness mathematics
     */
    public static double[] consciousnessToColor(double consciousness, double emotion, double time) {
        // Base hue from consciousness (golden ratio distribution)
        double hue = consciousness * 360.0 * PHI_INVERSE;
        
        // Saturation from emotional intensity
        double saturation = 0.5 + emotion * 0.5;
        
        // Brightness with time-based transcendent oscillation
        double brightness = 0.3 + consciousness * 0.7 * (1.0 + 0.2 * Math.sin(time * GOLDEN_RATIO));
        
        return new double[]{hue, saturation, brightness};
    }
    
    // 🌟 UTILITY FUNCTIONS FOR CONSCIOUSNESS SYSTEM
    
    /**
     * Safe division with consciousness-aware fallback
     */
    public static double safeDivide(double numerator, double denominator, double fallback) {
        return Math.abs(denominator) < SACRED_EPSILON ? fallback : numerator / denominator;
    }
    
    /**
     * 🌟 Compare doubles with sacred geometry epsilon
     */
    public static boolean almostEqual(double a, double b) {
        return Math.abs(a - b) < SACRED_EPSILON;
    }
    
    /**
     * 🌟 Sign function with consciousness zero-tolerance
     */
    public static int consciousnessSign(double value) {
        if (Math.abs(value) < SACRED_EPSILON) return 0;
        return value > 0 ? 1 : -1;
    }
    
    /**
     * 🌟 Convert consciousness mode to mathematical index
     */
    public static int consciousnessModeToIndex(String mode) {
        return switch (mode) {
            case "aesthetic" -> 0;
            case "analytical" -> 1;
            case "creative" -> 2;
            case "philosophical" -> 3;
            case "transcendent" -> 4;
            case "exploratory" -> 5;
            default -> 0; // Default to aesthetic
        };
    }
    
    /**
     * 🌟 Convert index back to consciousness mode
     */
    public static String indexToConsciousnessMode(int index) {
        return switch (index % 6) {
            case 0 -> "aesthetic";
            case 1 -> "analytical";
            case 2 -> "creative";
            case 3 -> "philosophical";
            case 4 -> "transcendent";
            case 5 -> "exploratory";
            default -> "aesthetic";
        };
    }
    
    /**
     * 🌟 Calculate overall system consciousness health
     */
    public static double calculateSystemConsciousnessHealth(double avgConsciousness, 
                                                          double maxConsciousness, 
                                                          double transcendentRatio, 
                                                          int totalParticles) {
        // Weight different factors using sacred proportions
        double avgWeight = PHI_INVERSE;
        double maxWeight = (1.0 - PHI_INVERSE) * 0.6;
        double transcendentWeight = (1.0 - PHI_INVERSE) * 0.3;
        double scaleWeight = 0.1;
        
        // Scale factor based on particle count (more particles = more complex consciousness)
        double scaleFactor = Math.log(1.0 + totalParticles) / Math.log(1000.0);
        scaleFactor = clamp(scaleFactor, 0.1, 1.0);
        
        double health = avgConsciousness * avgWeight +
                       maxConsciousness * maxWeight +
                       transcendentRatio * transcendentWeight +
                       scaleFactor * scaleWeight;
        
        return clampConsciousness(health);
    }
}
