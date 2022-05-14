const apiAddress = "http://localhost:8080/api/v1/reader";

export async function addReader(reader) {
    const response = await fetch(apiAddress, {
            method: 'POST',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
              },
            body: JSON.stringify(reader)
    });

    return response.json();
}