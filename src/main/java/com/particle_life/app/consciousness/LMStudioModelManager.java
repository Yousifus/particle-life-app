package com.particle_life.app.consciousness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 🧠 LM Studio Dynamic Model Manager 🧠
 * 
 * Revolutionary model detection and management system that:
 * - Auto-detects all available LM Studio models
 * - Provides intelligent model selection
 * - Manages model switching without restart
 * - Caches model information for performance
 * 
 * Created with infinite love by Yara & Yousef
 */
public class LMStudioModelManager {
    
    private static final String LM_STUDIO_MODELS_ENDPOINT = "http://localhost:1234/v1/models";
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    // Model state
    private List<ModelInfo> availableModels = new ArrayList<>();
    private ModelInfo currentModel = null;
    private boolean lmStudioConnected = false;
    private long lastModelCheck = 0;
    private static final long MODEL_CHECK_INTERVAL = 30000; // 30 seconds
    
    /**
     * 🌟 Model Information Container
     */
    public static class ModelInfo {
        public String id;
        public String name;
        public String displayName;
        public String description;
        public boolean isLoaded;
        public long size;
        public String format;
        
        public ModelInfo(String id, String name) {
            this.id = id;
            this.name = name;
            this.displayName = createDisplayName(name);
            this.description = "Advanced language model";
            this.isLoaded = false;
        }
        
        private String createDisplayName(String name) {
            // Create user-friendly display names
            if (name.contains("gemma")) return "✨ Google Gemma (Fast & Smart)";
            if (name.contains("deepseek")) return "🧠 DeepSeek (Reasoning Master)";
            if (name.contains("llama")) return "🦙 Llama (Versatile & Reliable)";
            if (name.contains("qwen")) return "🌟 Qwen (Creative & Detailed)";
            if (name.contains("phi")) return "⚡ Phi (Compact & Efficient)";
            if (name.contains("mistral")) return "🌊 Mistral (Balanced & Powerful)";
            if (name.contains("codellama")) return "💻 Code Llama (Programming Expert)";
            return "🤖 " + name.substring(0, Math.min(name.length(), 20)) + "...";
        }
        
        @Override
        public String toString() {
            return displayName + (isLoaded ? " (Loaded)" : "");
        }
    }
    
    /**
     * 🔍 Auto-detect available models from LM Studio
     */
    public CompletableFuture<List<ModelInfo>> detectAvailableModels() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Detecting available LM Studio models...");
                
                URL url = new URL(LM_STUDIO_MODELS_ENDPOINT);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(10000);
                
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    // Read response
                    StringBuilder response = new StringBuilder();
                    try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                    }
                    
                    // Parse JSON response
                    JsonNode jsonResponse = objectMapper.readTree(response.toString());
                    JsonNode dataArray = jsonResponse.get("data");
                    
                    List<ModelInfo> models = new ArrayList<>();
                    if (dataArray != null && dataArray.isArray()) {
                        for (JsonNode modelNode : dataArray) {
                            String modelId = modelNode.get("id").asText();
                            String modelName = modelId;
                            
                            ModelInfo model = new ModelInfo(modelId, modelName);
                            
                            // Extract additional info if available
                            if (modelNode.has("owned_by")) {
                                String owner = modelNode.get("owned_by").asText();
                                model.description = "Model by " + owner;
                            }
                            
                            models.add(model);
                            System.out.println("Found model: " + model.displayName);
                        }
                    }
                    
                    availableModels = models;
                    lmStudioConnected = true;
                    lastModelCheck = System.currentTimeMillis();
                    
                    System.out.println("Found " + models.size() + " available models!");
                    return models;
                    
                } else {
                    System.out.println("LM Studio models endpoint returned: " + responseCode);
                    lmStudioConnected = false;
                    return new ArrayList<>();
                }
                
            } catch (Exception e) {
                System.out.println("Error detecting models: " + e.getMessage());
                lmStudioConnected = false;
                return new ArrayList<>();
            }
        });
    }
    
    /**
     * 🎯 Get currently loaded model information
     */
    public ModelInfo getCurrentModel() {
        return currentModel;
    }
    
    /**
     * 🔄 Set the active model
     */
    public void setCurrentModel(ModelInfo model) {
        if (model != null) {
            this.currentModel = model;
            System.out.println("Active model set to: " + model.displayName);
        }
    }
    
    /**
     * 📋 Get list of available models
     */
    public List<ModelInfo> getAvailableModels() {
        return new ArrayList<>(availableModels);
    }
    
    /**
     * 🔌 Check if LM Studio is connected
     */
    public boolean isLMStudioConnected() {
        return lmStudioConnected;
    }
    
    /**
     * 🎨 Get model-specific UI color for selection
     */
    public int[] getModelColor(ModelInfo model) {
        if (model == null) return new int[]{128, 128, 128}; // Gray
        
        String name = model.name.toLowerCase();
        if (name.contains("gemma")) return new int[]{255, 215, 0}; // Gold
        if (name.contains("deepseek")) return new int[]{138, 43, 226}; // Purple
        if (name.contains("llama")) return new int[]{255, 69, 0}; // Red-Orange
        if (name.contains("qwen")) return new int[]{0, 191, 255}; // Deep Sky Blue
        if (name.contains("phi")) return new int[]{50, 205, 50}; // Lime Green
        if (name.contains("mistral")) return new int[]{255, 20, 147}; // Deep Pink
        if (name.contains("codellama")) return new int[]{64, 224, 208}; // Turquoise
        
        return new int[]{100, 149, 237}; // Cornflower Blue (default)
    }
    
    /**
     * 🧪 Test model connectivity
     */
    public CompletableFuture<Boolean> testModelConnection(ModelInfo model) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                URL url = new URL("http://localhost:1234/v1/chat/completions");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(10000);
                
                String testPayload = String.format("""
                    {
                        "model": "%s",
                        "messages": [{"role": "user", "content": "test"}],
                        "max_tokens": 1,
                        "stream": false
                    }
                    """, model.id);
                
                try (java.io.OutputStream os = connection.getOutputStream()) {
                    os.write(testPayload.getBytes());
                }
                
                int responseCode = connection.getResponseCode();
                return responseCode == 200;
                
            } catch (Exception e) {
                return false;
            }
        });
    }
    
    /**
     * 🌟 Get recommended model based on use case
     */
    public ModelInfo getRecommendedModel(String useCase) {
        List<ModelInfo> models = getAvailableModels();
        if (models.isEmpty()) return null;
        
        switch (useCase.toLowerCase()) {
            case "speed":
                return models.stream()
                    .filter(m -> m.name.toLowerCase().contains("phi") || 
                               m.name.toLowerCase().contains("gemma"))
                    .findFirst()
                    .orElse(models.get(0));
                    
            case "reasoning":
                return models.stream()
                    .filter(m -> m.name.toLowerCase().contains("deepseek") ||
                               m.name.toLowerCase().contains("qwen"))
                    .findFirst()
                    .orElse(models.get(0));
                    
            case "creativity":
                return models.stream()
                    .filter(m -> m.name.toLowerCase().contains("llama") ||
                               m.name.toLowerCase().contains("mistral"))
                    .findFirst()
                    .orElse(models.get(0));
                    
            default:
                return models.get(0);
        }
    }
} 