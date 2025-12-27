import unittest
from app import fetch_status

class TestApp(unittest.TestCase):

    def test_status_code(self):
        self.assertEqual(fetch_status(), 200)

if __name__ == '__main__':
    unittest.main()
