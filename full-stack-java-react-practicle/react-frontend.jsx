import { useState } from "react";
const API_URL = "http://192.168.1.3:5005/";
const App = () => {
  const [input, setInput] = useState("");
  const [password, setPassword] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [serverResponse, setServerResponse] = useState([]);
  const handleApiCall = async (e) => {
    e.preventDefault();
    setIsLoading(true);
    try {
      const response = await fetch(API_URL + "user/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          name: input,
          password: password,
        }),
      });
      const result = response.json();
      if (result.status === 1) {
        setServerResponse(result.data);
      } else {
        console.log("Login Failed");
      }
      console.log(result);
    } catch (error) {
      console.log(error);
    } finally {
      setIsLoading(false);
    }
  };
  console.log(serverResponse);
  return (
    <div>
      <form onSubmit={handleApiCall}>
        <label>username</label>
        <input
          type="text"
          value={input}
          onChange={(e) => setInput(e.target.value)}
        />
        <label>password</label>
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button type="submit">Submit</button>
      </form>
      {isLoading && (
        <>
          <div>Loading</div>
          <pre>{serverResponse}</pre>
        </>
      )}
    </div>
  );
};
export default App;
