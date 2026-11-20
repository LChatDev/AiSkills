import unittest
from demo import summarize
class SummaryTests(unittest.TestCase):
    def test_example(self):
        self.assertEqual(summarize(["ready","ready","pending"]), {"total":3,"ready":2})
    def test_empty(self):
        self.assertEqual(summarize([]), {"total":0,"ready":0})
if __name__ == "__main__":
    unittest.main()
