"""Local deterministic checklist summary."""
def summarize(items):
    return {"total":len(items),"ready":sum(v == "ready" for v in items)}
if __name__ == "__main__":
    print(summarize(["ready","ready","pending"]))
