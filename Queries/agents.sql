-- "Write an SQL query to find the top 5 agents with the highest call success rates in the last 30 days. How would you optimize this query?"

SELECT agent_id,
       SUM(CASE WHEN call_outcome = 'success' THEN 1 ELSE 0 END) / COUNT(*) as success_rate
FROM call_history
WHERE timestamp >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)
GROUP BY agent_id
ORDER BY success_rate DESC
LIMIT 5;


-- FROM Call_history: Look at all call records
-- WHERE timestamp >= DATE_SUB(CURDATE(), INTERVAL 30 DAY): Only look at calls from the last 30 days
-- GROUP BY agent_id: Group all calls by each agent
-- The success rate calculation:
-- SUM(CASE WHEN call_outcome = 'success' THEN 1 ELSE O END): Count successful calls
-- COUNT(*): Count total calls
-- Dividing these gives us: (successful calls) / (total calls)
-- ORDER BY success_rate DESC: Sort agents from highest to lowest success rate
-- LIMIT 5: Show only the top 5 agents
-- So this query finds the top 5 performing agents based on their success rate over the last month.
